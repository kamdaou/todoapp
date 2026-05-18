package td.cadet.todochad.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import td.cadet.todochad.model.Tache

// ==========================================================
// TODO 3 — Créer l'écran de détail d'une tâche
// ==========================================================
//
// EXERCICE : Ce fichier a été créé pour vous, mais dans les
// prochains TPs, vous devrez créer vos fichiers vous-mêmes !
//
// Ce composable affiche le détail d'une tâche et permet
// de la marquer comme terminée ou de la supprimer.
//
// Paramètres :
//   - tache: Tache
//   - onToggleTerminee: (Tache) -> Unit
//   - onSupprimer: () -> Unit
//   - onRetour: () -> Unit
//   - modifier: Modifier
//
// Structure attendue :
//   Scaffold(
//       topBar = {
//           TopAppBar(
//               title = { Text("Détail") },
//               navigationIcon = {
//                   IconButton(onClick = onRetour) {
//                       Icon(Icons.AutoMirrored.Filled.ArrowBack, "Retour")
//                   }
//               }
//           )
//       }
//   ) { innerPadding ->
//       Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
//
//           // Titre de la tâche en gros
//           Text(
//               text = tache.titre,
//               style = MaterialTheme.typography.headlineMedium
//           )
//
//           Spacer(modifier = Modifier.height(8.dp))
//
//           // Description
//           if (tache.description.isNotBlank()) {
//               Text(
//                   text = tache.description,
//                   style = MaterialTheme.typography.bodyLarge
//               )
//               Spacer(modifier = Modifier.height(16.dp))
//           }
//
//           // Ligne avec Checkbox + texte "Terminée"
//           Row(verticalAlignment = CenterVertically) {
//               Checkbox(
//                   checked = tache.terminee,
//                   onCheckedChange = { onToggleTerminee(tache) }
//               )
//               Text("Terminée")
//           }
//
//           Spacer(modifier = Modifier.height(16.dp))
//
//           // Bouton Supprimer (style OutlinedButton, couleur rouge)
//           OutlinedButton(
//               onClick = onSupprimer,
//               modifier = Modifier.fillMaxWidth(),
//               colors = ButtonDefaults.outlinedButtonColors(
//                   contentColor = MaterialTheme.colorScheme.error
//               )
//           ) {
//               Icon(Icons.Default.Delete, contentDescription = null)
//               Spacer(modifier = Modifier.width(8.dp))
//               Text("Supprimer cette tâche")
//           }
//       }
//   }
//
// Composants à importer :
//   - Scaffold, TopAppBar, IconButton, Icon (material3)
//   - Column, Row, Spacer (foundation.layout)
//   - Checkbox, Text, OutlinedButton, ButtonDefaults (material3)
//   - MaterialTheme (material3)
// ==========================================================

@Composable
fun DetailTaskScreen(
    tache: Tache,
    onToggleTerminee: (Tache) -> Unit,
    onSupprimer: () -> Unit,
    onRetour: () -> Unit,
    modifier: Modifier = Modifier
) {
    // TODO 3 : Implémentez le contenu ici
}
