package td.cadet.todochad.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import td.cadet.todochad.model.Tache

// ==========================================================
// TODO 3 — Créer l'écran liste des tâches
// ==========================================================
//
// Ce composable affiche la liste de toutes les tâches et
// permet d'en ajouter de nouvelles via un bouton flottant (FAB).
//
// Paramètres :
//   - taches: List<Tache> (liste des tâches à afficher)
//   - onToggleTerminee: (Tache) -> Unit (callback quand on coche/décoche)
//   - onAjouterClick: () -> Unit (callback quand on clique sur le FAB)
//   - modifier: Modifier (optionnel)
//
// Structure attendue :
//   Scaffold(
//       topBar = {
//           TopAppBar(title = { Text("TodoChad") })
//       },
//       floatingActionButton = {
//           FloatingActionButton(onClick = onAjouterClick) {
//               Icon(Icons.Default.Add, contentDescription = "Ajouter")
//           }
//       }
//   ) { innerPadding ->
//       if (taches.isEmpty()) {
//           // Afficher un message centré : "Aucune tâche pour le moment"
//           // Utiliser Box(contentAlignment = Center) avec un Text
//       } else {
//           LazyColumn {
//               items(taches) { tache ->
//                   TaskItem(tache, onToggleTerminee)
//               }
//           }
//       }
//   }
//
// Composants à importer :
//   - Scaffold, TopAppBar, FloatingActionButton (material3)
//   - LazyColumn, items (foundation.lazy)
//   - Icon, Icons (material.icons)
//   - Box (foundation.layout)
//
// Astuce : n'oubliez pas d'appliquer innerPadding au contenu
//          via Modifier.padding(innerPadding)
// ==========================================================

@Composable
fun ListTasksScreen(
    taches: List<Tache>,
    onToggleTerminee: (Tache) -> Unit,
    onAjouterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // TODO 3 : Implémentez le contenu ici
}
