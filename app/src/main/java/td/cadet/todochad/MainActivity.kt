package td.cadet.todochad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import td.cadet.todochad.ui.theme.TodoChadTheme

// ==========================================================
// TODO 4 — Initialiser la base de données Room dans MainActivity
// ==========================================================
//
// Maintenant que Room est en place, il faut créer l'instance
// de la base de données et la passer au NavHost.
//
// Étapes :
//   1. Créer la base de données (une seule fois, lazy) :
//
//      private val database by lazy {
//          Room.databaseBuilder(
//              applicationContext,
//              TodoChadDatabase::class.java,
//              "todochad_database"
//          ).build()
//      }
//
//      private val tacheDao by lazy { database.tacheDao() }
//
//   2. Passer le DAO au composable TodoChadApp :
//
//      TodoChadApp(tacheDao = tacheDao)
//
// Imports nécessaires :
//   - androidx.room.Room
//   - td.cadet.todochad.data.local.TodoChadDatabase
// ==========================================================

class MainActivity : ComponentActivity() {
    // TODO 4a : Déclarez la database et le dao ici (avec by lazy)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoChadTheme {
                // TODO 4b : Passez le dao à TodoChadApp
                TodoChadApp()
            }
        }
    }
}

// ==========================================================
// TODO 5 — Remplacer l'état en mémoire par Room
// ==========================================================
//
// Le composable TodoChadApp doit maintenant :
//   1. Recevoir le TacheDao en paramètre
//   2. Observer les tâches via Flow (collectAsState)
//   3. Utiliser des coroutines pour les opérations d'écriture
//
// Nouveau code :
//
//   @Composable
//   fun TodoChadApp(tacheDao: TacheDao) {
//       val taches by tacheDao.getAllTaches()
//           .map { entities -> entities.map { it.toTache() } }
//           .collectAsState(initial = emptyList())
//       val scope = rememberCoroutineScope()
//
//       TodoChadNavHost(
//           taches = taches,
//           onToggleTerminee = { tache ->
//               scope.launch {
//                   tacheDao.update(tache.copy(terminee = !tache.terminee).toEntity())
//               }
//           },
//           onAjouterTache = { titre, description ->
//               scope.launch {
//                   tacheDao.insert(TacheEntity(titre = titre, description = description))
//               }
//           },
//           onSupprimerTache = { tache ->
//               scope.launch {
//                   tacheDao.delete(tache.toEntity())
//               }
//           }
//       )
//   }
//
// Imports nécessaires :
//   - androidx.compose.runtime.collectAsState
//   - androidx.compose.runtime.rememberCoroutineScope
//   - kotlinx.coroutines.flow.map
//   - kotlinx.coroutines.launch
//   - td.cadet.todochad.data.local.TacheDao
//   - td.cadet.todochad.data.local.TacheEntity
//   - td.cadet.todochad.data.local.toTache
//   - td.cadet.todochad.data.local.toEntity
//
// Notez : plus besoin de remember/mutableStateOf pour les taches !
// Room + Flow s'en charge automatiquement.
// ==========================================================

@Composable
fun TodoChadApp() {
    // TODO 5 : Remplacez ce code par la version avec Room (voir ci-dessus)
}

@Preview(showBackground = true)
@Composable
fun TodoChadAppPreview() {
    TodoChadTheme {
        TodoChadApp()
    }
}
