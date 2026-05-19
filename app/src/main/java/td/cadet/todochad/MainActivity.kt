package td.cadet.todochad

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import td.cadet.todochad.data.local.TacheDao
import td.cadet.todochad.data.local.TacheEntity
import td.cadet.todochad.data.local.TodoChadDatabase
import td.cadet.todochad.data.local.toEntity
import td.cadet.todochad.data.local.toTache
import td.cadet.todochad.data.remote.RetrofitInstance
import td.cadet.todochad.data.remote.toTacheEntity
import td.cadet.todochad.navigation.TodoChadNavHost
import td.cadet.todochad.notifications.NotificationHelper
import td.cadet.todochad.ui.theme.TodoChadTheme

// ==================================================================
// TODO 1 — Créer le Repository (data/repository/TacheRepository.kt)
// ==================================================================
// CRÉEZ un nouveau fichier : data/repository/TacheRepository.kt
//
// Le Repository centralise l'accès aux données (local + remote).
// Il reçoit le TacheDao et le TodoApi en paramètre.
//
//   class TacheRepository @Inject constructor(
//       private val tacheDao: TacheDao,
//       private val todoApi: TodoApi
//   ) {
//       fun getAllTaches(): Flow<List<Tache>> =
//           tacheDao.getAllTaches().map { entities -> entities.map { it.toTache() } }
//
//       suspend fun insert(tache: TacheEntity) = tacheDao.insert(tache)
//       suspend fun update(tache: TacheEntity) = tacheDao.update(tache)
//       suspend fun delete(tache: TacheEntity) = tacheDao.delete(tache)
//
//       suspend fun syncFromApi(): List<TodoDto> = todoApi.getTodos()
//   }
// ==================================================================

// ==================================================================
// TODO 2 — Créer le ViewModel (ui/screens/ListTachesViewModel.kt)
// ==================================================================
// CRÉEZ un nouveau fichier : ui/screens/ListTachesViewModel.kt
//
// Le ViewModel gère l'état et la logique de l'écran liste.
// Toute la logique actuellement dans TodoChadApp() doit être
// déplacée ici.
//
//   @HiltViewModel
//   class ListTachesViewModel @Inject constructor(
//       private val repository: TacheRepository
//   ) : ViewModel() {
//
//       val taches: StateFlow<List<Tache>> = repository.getAllTaches()
//           .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
//
//       private val _isSyncing = MutableStateFlow(false)
//       val isSyncing: StateFlow<Boolean> = _isSyncing.asStateFlow()
//
//       fun toggleTerminee(tache: Tache) { viewModelScope.launch { ... } }
//       fun ajouterTache(titre: String, description: String) { ... }
//       fun supprimerTache(tache: Tache) { ... }
//       fun sync() { ... }
//   }
// ==================================================================

// ==================================================================
// TODO 3 — Créer le module Hilt (di/AppModule.kt)
// ==================================================================
// CRÉEZ un nouveau fichier : di/AppModule.kt
//
//   @Module
//   @InstallIn(SingletonComponent::class)
//   object AppModule {
//
//       @Provides @Singleton
//       fun provideDatabase(@ApplicationContext context: Context): TodoChadDatabase =
//           Room.databaseBuilder(context, TodoChadDatabase::class.java, "todochad_database").build()
//
//       @Provides
//       fun provideTacheDao(database: TodoChadDatabase): TacheDao = database.tacheDao()
//
//       @Provides @Singleton
//       fun provideTodoApi(): TodoApi = RetrofitInstance.api
//   }
// ==================================================================

// ==================================================================
// TODO 4 — Créer la classe Application annotée @HiltAndroidApp
// ==================================================================
// CRÉEZ un nouveau fichier : TodoChadApplication.kt
//
//   @HiltAndroidApp
//   class TodoChadApplication : Application()
//
// Puis dans AndroidManifest.xml, ajoutez :
//   android:name=".TodoChadApplication"
// dans la balise <application>
// ==================================================================

// ==================================================================
// TODO 5 — Annoter MainActivity avec @AndroidEntryPoint
// ==================================================================
// Ajoutez @AndroidEntryPoint sur la classe MainActivity.
// Supprimez la création manuelle de database/dao (Hilt s'en charge).
// Dans TodoChadApp, utilisez :
//   val viewModel: ListTachesViewModel = hiltViewModel()
//   val taches by viewModel.taches.collectAsState()
//   val isSyncing by viewModel.isSyncing.collectAsState()
// ==================================================================

// ==================================================================
// TODO 6 — Écrire un test unitaire (test/.../ListTachesViewModelTest.kt)
// ==================================================================
// CRÉEZ : app/src/test/java/td/cadet/todochad/ListTachesViewModelTest.kt
//
// Utilisez MockK pour moquer le Repository :
//
//   class ListTachesViewModelTest {
//       @Test
//       fun `ajouterTache appelle repository insert`() = runTest {
//           val repository = mockk<TacheRepository>(relaxed = true)
//           val viewModel = ListTachesViewModel(repository)
//           viewModel.ajouterTache("Test", "Description")
//           coVerify { repository.insert(any()) }
//       }
//   }
// ==================================================================

class MainActivity : ComponentActivity() {

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            TodoChadDatabase::class.java,
            "todochad_database"
        ).build()
    }

    private val tacheDao by lazy { database.tacheDao() }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { _ -> }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        NotificationHelper.createNotificationChannel(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }

        enableEdgeToEdge()
        setContent {
            TodoChadTheme {
                TodoChadApp(tacheDao = tacheDao)
            }
        }
    }
}

@Composable
fun TodoChadApp(tacheDao: TacheDao) {
    val taches by tacheDao.getAllTaches()
        .map { entities -> entities.map { it.toTache() } }
        .collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()
    var isSyncing by remember { mutableStateOf(false) }

    TodoChadNavHost(
        taches = taches,
        onToggleTerminee = { tache ->
            scope.launch {
                tacheDao.update(tache.copy(terminee = !tache.terminee).toEntity())
            }
        },
        onAjouterTache = { titre, description ->
            scope.launch {
                tacheDao.insert(TacheEntity(titre = titre, description = description))
            }
        },
        onSupprimerTache = { tache ->
            scope.launch {
                tacheDao.delete(tache.toEntity())
            }
        },
        onSyncClick = {
            scope.launch {
                isSyncing = true
                try {
                    val todos = RetrofitInstance.api.getTodos()
                    todos.take(20).forEach { dto ->
                        tacheDao.insert(dto.toTacheEntity())
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    isSyncing = false
                }
            }
        },
        isSyncing = isSyncing
    )
}

@Preview(showBackground = true)
@Composable
fun TodoChadAppPreview() {
    TodoChadTheme {
        // Preview sans base de données
    }
}
