package td.cadet.todochad.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import td.cadet.todochad.R
import td.cadet.todochad.model.Tache
import td.cadet.todochad.ui.components.TaskItem

// ==========================================================
// TODO 4 — Ajouter un bouton de synchronisation
// ==========================================================
//
// Ajoutez un nouveau paramètre au composable :
//   - onSyncClick: () -> Unit (callback pour synchroniser avec l'API)
//   - isSyncing: Boolean (pour afficher un indicateur de chargement)
//
// Dans le TopAppBar.actions, ajoutez un IconButton AVANT le Settings :
//
//   if (isSyncing) {
//       CircularProgressIndicator(
//           modifier = Modifier.size(24.dp),
//           strokeWidth = 2.dp
//       )
//   } else {
//       IconButton(onClick = onSyncClick) {
//           Icon(Icons.Default.Refresh, contentDescription = "Synchroniser")
//       }
//   }
//
// Imports supplémentaires :
//   - androidx.compose.material3.CircularProgressIndicator
//   - androidx.compose.material.icons.filled.Refresh
//   - androidx.compose.foundation.layout.size
//   - androidx.compose.ui.unit.dp
// ==========================================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListTasksScreen(
    taches: List<Tache>,
    onToggleTerminee: (Tache) -> Unit,
    onAjouterClick: () -> Unit,
    onTacheClick: (Tache) -> Unit,
    onParametresClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                actions = {
                    IconButton(onClick = onParametresClick) {
                        Icon(Icons.Default.Settings, contentDescription = stringResource(R.string.parametres))
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAjouterClick) {
                Icon(Icons.Default.Add, contentDescription = stringResource(R.string.ajouter))
            }
        },
        modifier = modifier
    ) { innerPadding ->
        if (taches.isEmpty()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Text(stringResource(R.string.aucune_tache))
            }
        } else {
            LazyColumn(modifier = Modifier.padding(innerPadding)) {
                items(taches, key = { it.id }) { tache ->
                    TaskItem(
                        tache = tache,
                        onToggleTerminee = onToggleTerminee,
                        modifier = Modifier.clickable { onTacheClick(tache) }
                    )
                }
            }
        }
    }
}
