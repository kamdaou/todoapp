package td.cadet.todochad.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import td.cadet.todochad.R

// ==========================================================
// TODO 3 — Ajouter un switch "Rappel" et planifier via WorkManager
// ==========================================================
//
// Ajoutez un Switch pour activer un rappel dans 1 minute (démo).
//
// Nouveaux états locaux :
//   var rappelActive by remember { mutableStateOf(false) }
//
// Dans le Column, après le bouton, ajoutez :
//
//   Row(verticalAlignment = CenterVertically) {
//       Switch(
//           checked = rappelActive,
//           onCheckedChange = { rappelActive = it }
//       )
//       Spacer(modifier = Modifier.width(8.dp))
//       Text("Activer un rappel (1 min)")
//   }
//
// Modifiez le onClick du Button pour planifier le rappel :
//
//   onClick = {
//       if (rappelActive) {
//           val workRequest = OneTimeWorkRequestBuilder<RappelWorker>()
//               .setInitialDelay(1, TimeUnit.MINUTES)
//               .setInputData(workDataOf(
//                   "titre" to "Rappel : $titre",
//                   "message" to description.ifBlank { "N'oubliez pas cette tâche !" }
//               ))
//               .build()
//           WorkManager.getInstance(context).enqueue(workRequest)
//       }
//       onAjouter(titre, description)
//   }
//
// Pour obtenir le context dans un Composable :
//   val context = LocalContext.current
//
// Imports nécessaires :
//   - androidx.compose.material3.Switch
//   - androidx.compose.foundation.layout.Row, width
//   - androidx.compose.ui.platform.LocalContext
//   - androidx.work.OneTimeWorkRequestBuilder
//   - androidx.work.WorkManager
//   - androidx.work.workDataOf
//   - java.util.concurrent.TimeUnit
//   - td.cadet.todochad.notifications.RappelWorker
// ==========================================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    onAjouter: (titre: String, description: String) -> Unit,
    onAnnuler: () -> Unit,
    modifier: Modifier = Modifier
) {
    var titre by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.nouvelle_tache)) },
                navigationIcon = {
                    IconButton(onClick = onAnnuler) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.retour)
                        )
                    }
                }
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = titre,
                onValueChange = { titre = it },
                label = { Text(stringResource(R.string.titre)) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text(stringResource(R.string.description)) },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onAjouter(titre, description) },
                modifier = Modifier.fillMaxWidth(),
                enabled = titre.isNotBlank()
            ) {
                Text(stringResource(R.string.ajouter_tache))
            }
        }
    }
}
