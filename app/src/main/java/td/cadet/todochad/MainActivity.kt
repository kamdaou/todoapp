package td.cadet.todochad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import td.cadet.todochad.ui.theme.TodoChadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoChadTheme {
                TodoChadApp()
            }
        }
    }
}

// ==========================================================
// TODO 5 — Câbler les écrans dans le composable principal
// ==========================================================
//
// Ce composable gère l'état global de l'application (pour l'instant
// sans navigation, on utilise un booléen pour basculer entre écrans).
//
// État nécessaire :
//   var taches by remember { mutableStateOf(listOf<Tache>()) }
//   var ecranAjout by remember { mutableStateOf(false) }
//   var prochainId by remember { mutableIntStateOf(1) }
//
// Logique :
//   if (ecranAjout) {
//       AddTaskScreen(
//           onAjouter = { titre, description ->
//               val nouvelleTache = Tache(
//                   id = prochainId++,
//                   titre = titre,
//                   description = description
//               )
//               taches = taches + nouvelleTache
//               ecranAjout = false
//           },
//           onAnnuler = { ecranAjout = false }
//       )
//   } else {
//       ListTasksScreen(
//           taches = taches,
//           onToggleTerminee = { tache ->
//               taches = taches.map {
//                   if (it.id == tache.id) it.copy(terminee = !it.terminee) else it
//               }
//           },
//           onAjouterClick = { ecranAjout = true }
//       )
//   }
//
// Imports nécessaires :
//   - remember, mutableStateOf, getValue, setValue (runtime)
//   - mutableIntStateOf (runtime)
//   - td.cadet.todochad.model.Tache
//   - td.cadet.todochad.ui.screens.ListTasksScreen
//   - td.cadet.todochad.ui.screens.AddTaskScreen
// ==========================================================

@Composable
fun TodoChadApp() {
    // TODO 5 : Implémentez le contenu ici
}

@Preview(showBackground = true)
@Composable
fun TodoChadAppPreview() {
    TodoChadTheme {
        TodoChadApp()
    }
}
