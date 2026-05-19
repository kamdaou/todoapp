package td.cadet.todochad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import td.cadet.todochad.ui.theme.TodoChadTheme

// ==========================================================
// TODO 5 — Demander les permissions et créer le canal de notification
// ==========================================================
//
// Dans onCreate, AVANT setContent :
//
//   1. Créer le canal de notification :
//      NotificationHelper.createNotificationChannel(this)
//
//   2. Demander la permission POST_NOTIFICATIONS (Android 13+) :
//      val requestPermissionLauncher = registerForActivityResult(
//          ActivityResultContracts.RequestPermission()
//      ) { isGranted -> /* on peut logger le résultat */ }
//
//      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//          requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
//      }
//
// Imports nécessaires :
//   - android.Manifest
//   - android.os.Build
//   - androidx.activity.result.contract.ActivityResultContracts
//   - td.cadet.todochad.notifications.NotificationHelper
// ==========================================================

class MainActivity : ComponentActivity() {

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            TodoChadDatabase::class.java,
            "todochad_database"
        ).build()
    }

    private val tacheDao by lazy { database.tacheDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
