package td.cadet.todochad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import td.cadet.todochad.model.Tache
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
// TODO 5 — Remplacer la logique d'écran par le NavHost
// ==========================================================
//
// Maintenant que la navigation est en place, il faut :
//   1. Supprimer la variable ecranAjout (plus besoin, le NavHost gère)
//   2. Garder la gestion d'état (taches, prochainId)
//   3. Ajouter un callback onSupprimerTache
//   4. Appeler TodoChadNavHost à la place de la logique if/else
//
// Nouveau code :
//   @Composable
//   fun TodoChadApp() {
//       var taches by remember { mutableStateOf(listOf<Tache>()) }
//       var prochainId by remember { mutableIntStateOf(1) }
//
//       TodoChadNavHost(
//           taches = taches,
//           onToggleTerminee = { tache ->
//               taches = taches.map {
//                   if (it.id == tache.id) it.copy(terminee = !it.terminee) else it
//               }
//           },
//           onAjouterTache = { titre, description ->
//               taches = taches + Tache(
//                   id = prochainId++,
//                   titre = titre,
//                   description = description
//               )
//           },
//           onSupprimerTache = { tache ->
//               taches = taches.filter { it.id != tache.id }
//           }
//       )
//   }
//
// Import nécessaire :
//   - td.cadet.todochad.navigation.TodoChadNavHost
// ==========================================================

@Composable
fun TodoChadApp() {
    // TODO 5 : Remplacez le code ci-dessous par le NavHost
    var taches by remember { mutableStateOf(listOf<Tache>()) }
    var prochainId by remember { mutableIntStateOf(1) }

    // Ancien code TP1 — à remplacer par TodoChadNavHost(...)
}

@Preview(showBackground = true)
@Composable
fun TodoChadAppPreview() {
    TodoChadTheme {
        TodoChadApp()
    }
}
