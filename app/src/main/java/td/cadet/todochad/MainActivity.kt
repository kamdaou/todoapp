package td.cadet.todochad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import td.cadet.todochad.data.local.TacheDao
import td.cadet.todochad.data.local.TacheEntity
import td.cadet.todochad.data.local.TodoChadDatabase
import td.cadet.todochad.data.local.toEntity
import td.cadet.todochad.data.local.toTache
import td.cadet.todochad.navigation.TodoChadNavHost
import td.cadet.todochad.ui.theme.TodoChadTheme

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

// ==========================================================
// TODO 5 — Ajouter la synchronisation Retrofit dans TodoChadApp
// ==========================================================
//
// Ajoutez la logique de synchronisation :
//
//   1. Créer un état pour le chargement :
//      var isSyncing by remember { mutableStateOf(false) }
//
//   2. Ajouter les callbacks onSyncClick et isSyncing au NavHost :
//      onSyncClick = {
//          scope.launch {
//              isSyncing = true
//              try {
//                  val todos = RetrofitInstance.api.getTodos()
//                  // Limiter à 20 tâches pour la démo
//                  todos.take(20).forEach { dto ->
//                      tacheDao.insert(dto.toTacheEntity())
//                  }
//              } catch (e: Exception) {
//                  // Gérer l'erreur (on verra le Snackbar plus tard)
//                  e.printStackTrace()
//              } finally {
//                  isSyncing = false
//              }
//          }
//      }
//
// Imports supplémentaires :
//   - td.cadet.todochad.data.remote.RetrofitInstance
//   - td.cadet.todochad.data.remote.toTacheEntity
//   - androidx.compose.runtime.mutableStateOf
//   - androidx.compose.runtime.setValue
// ==========================================================

@Composable
fun TodoChadApp(tacheDao: TacheDao) {
    val taches by tacheDao.getAllTaches()
        .map { entities -> entities.map { it.toTache() } }
        .collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()

    // TODO 5 : Ajoutez var isSyncing et passez onSyncClick/isSyncing au NavHost

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
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TodoChadAppPreview() {
    TodoChadTheme {
        // Preview sans base de données
    }
}
