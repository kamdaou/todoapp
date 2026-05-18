package td.cadet.todochad.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// ==========================================================
// TODO 4 — Créer l'écran des paramètres
// ==========================================================
//
// EXERCICE : Ce fichier a été créé pour vous, mais dans les
// prochains TPs, vous devrez créer vos fichiers vous-mêmes !
//
// Pour l'instant, cet écran est simple : il affiche juste
// un titre et un message. On l'enrichira dans les TPs suivants.
//
// Paramètres :
//   - onRetour: () -> Unit
//   - modifier: Modifier
//
// Structure attendue :
//   Scaffold(
//       topBar = {
//           TopAppBar(
//               title = { Text("Paramètres") },
//               navigationIcon = {
//                   IconButton(onClick = onRetour) {
//                       Icon(Icons.AutoMirrored.Filled.ArrowBack, "Retour")
//                   }
//               }
//           )
//       }
//   ) { innerPadding ->
//       Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
//           Text(
//               text = "Paramètres de l'application",
//               style = MaterialTheme.typography.titleLarge
//           )
//           Spacer(modifier = Modifier.height(16.dp))
//           Text(
//               text = "Les paramètres seront disponibles dans une prochaine version.",
//               style = MaterialTheme.typography.bodyMedium
//           )
//       }
//   }
// ==========================================================

@Composable
fun SettingsScreen(
    onRetour: () -> Unit,
    modifier: Modifier = Modifier
) {
    // TODO 4 : Implémentez le contenu ici
}
