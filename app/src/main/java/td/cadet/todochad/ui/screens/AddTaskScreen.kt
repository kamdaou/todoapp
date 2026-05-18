package td.cadet.todochad.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// ==========================================================
// TODO 4 — Créer l'écran d'ajout de tâche
// ==========================================================
//
// Ce composable affiche un formulaire pour créer une nouvelle tâche.
//
// Paramètres :
//   - onAjouter: (titre: String, description: String) -> Unit
//       (callback appelé quand l'utilisateur valide le formulaire)
//   - onAnnuler: () -> Unit
//       (callback pour revenir en arrière)
//   - modifier: Modifier (optionnel)
//
// Structure attendue :
//   Scaffold(
//       topBar = {
//           TopAppBar(
//               title = { Text("Nouvelle tâche") },
//               navigationIcon = {
//                   IconButton(onClick = onAnnuler) {
//                       Icon(Icons.AutoMirrored.Filled.ArrowBack, "Retour")
//                   }
//               }
//           )
//       }
//   ) { innerPadding ->
//       Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
//
//           // Champ titre
//           OutlinedTextField(
//               value = titre,            // variable d'état locale
//               onValueChange = { ... },
//               label = { Text("Titre") },
//               modifier = Modifier.fillMaxWidth()
//           )
//
//           Spacer(modifier = Modifier.height(8.dp))
//
//           // Champ description
//           OutlinedTextField(
//               value = description,      // variable d'état locale
//               onValueChange = { ... },
//               label = { Text("Description") },
//               modifier = Modifier.fillMaxWidth(),
//               minLines = 3
//           )
//
//           Spacer(modifier = Modifier.height(16.dp))
//
//           // Bouton de validation
//           Button(
//               onClick = { onAjouter(titre, description) },
//               modifier = Modifier.fillMaxWidth(),
//               enabled = titre.isNotBlank()  // désactivé si titre vide
//           ) {
//               Text("Ajouter la tâche")
//           }
//       }
//   }
//
// État local nécessaire (avec remember + mutableStateOf) :
//   var titre by remember { mutableStateOf("") }
//   var description by remember { mutableStateOf("") }
//
// Composants à importer :
//   - OutlinedTextField, Button, Text (material3)
//   - Column, Spacer, fillMaxWidth (foundation.layout)
//   - remember, mutableStateOf, getValue, setValue (runtime)
// ==========================================================

@Composable
fun AddTaskScreen(
    onAjouter: (titre: String, description: String) -> Unit,
    onAnnuler: () -> Unit,
    modifier: Modifier = Modifier
) {
    // TODO 4 : Implémentez le contenu ici
}
