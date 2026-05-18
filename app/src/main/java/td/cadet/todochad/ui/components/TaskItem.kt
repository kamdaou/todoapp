package td.cadet.todochad.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import td.cadet.todochad.model.Tache

// ==========================================================
// TODO 2 — Créer le composable TaskItem
// ==========================================================
//
// Ce composable affiche UNE tâche dans la liste.
// Il reçoit en paramètres :
//   - tache: Tache (la tâche à afficher)
//   - onToggleTerminee: (Tache) -> Unit (callback quand on coche/décoche)
//   - modifier: Modifier (optionnel)
//
// Structure attendue :
//   Card {
//       Row(verticalAlignment = CenterVertically) {
//           Checkbox(checked = tache.terminee, onCheckedChange = ...)
//           Column {
//               Text(tache.titre)          // en gras (FontWeight.Bold)
//               Text(tache.description)    // style bodySmall, couleur grise
//           }
//       }
//   }
//
// Composants à importer :
//   - Card (androidx.compose.material3)
//   - Row, Column (androidx.compose.foundation.layout)
//   - Checkbox (androidx.compose.material3)
//   - Text (androidx.compose.material3)
//
// Astuce : utilisez Modifier.padding(16.dp) pour l'espacement
//          et Modifier.weight(1f) sur la Column pour qu'elle
//          prenne tout l'espace restant.
// ==========================================================

@Composable
fun TaskItem(
    tache: Tache,
    onToggleTerminee: (Tache) -> Unit,
    modifier: Modifier = Modifier
) {
    // TODO 2 : Implémentez le contenu ici
}
