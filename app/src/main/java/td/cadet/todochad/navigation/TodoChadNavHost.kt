package td.cadet.todochad.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import td.cadet.todochad.model.Tache

// ==========================================================
// TODO 2 — Créer le NavHost de l'application
// ==========================================================
//
// Ce composable configure la navigation entre tous les écrans.
//
// Paramètres à recevoir :
//   - taches: List<Tache>
//   - onToggleTerminee: (Tache) -> Unit
//   - onAjouterTache: (String, String) -> Unit
//   - onSupprimerTache: (Tache) -> Unit
//   - modifier: Modifier
//
// Structure attendue :
//
//   val navController = rememberNavController()
//
//   NavHost(
//       navController = navController,
//       startDestination = ListTaches     // la destination objet
//   ) {
//       composable<ListTaches> {
//           ListTasksScreen(
//               taches = taches,
//               onToggleTerminee = onToggleTerminee,
//               onAjouterClick = { navController.navigate(AjouterTache) },
//               onTacheClick = { tache -> navController.navigate(DetailTache(tache.id)) },
//               onParametresClick = { navController.navigate(Parametres) }
//           )
//       }
//
//       composable<AjouterTache> {
//           AddTaskScreen(
//               onAjouter = { titre, desc ->
//                   onAjouterTache(titre, desc)
//                   navController.popBackStack()
//               },
//               onAnnuler = { navController.popBackStack() }
//           )
//       }
//
//       composable<DetailTache> { backStackEntry ->
//           val detailDest = backStackEntry.toRoute<DetailTache>()
//           val tache = taches.find { it.id == detailDest.id }
//           if (tache != null) {
//               DetailTaskScreen(
//                   tache = tache,
//                   onToggleTerminee = onToggleTerminee,
//                   onSupprimer = {
//                       onSupprimerTache(tache)
//                       navController.popBackStack()
//                   },
//                   onRetour = { navController.popBackStack() }
//               )
//           }
//       }
//
//       composable<Parametres> {
//           SettingsScreen(
//               onRetour = { navController.popBackStack() }
//           )
//       }
//   }
//
// Imports nécessaires :
//   - androidx.navigation.compose.NavHost
//   - androidx.navigation.compose.composable
//   - androidx.navigation.compose.rememberNavController
//   - androidx.navigation.toRoute
//   - Toutes les destinations de Destinations.kt
//   - Tous les écrans de ui.screens.*
// ==========================================================

@Composable
fun TodoChadNavHost(
    taches: List<Tache>,
    onToggleTerminee: (Tache) -> Unit,
    onAjouterTache: (String, String) -> Unit,
    onSupprimerTache: (Tache) -> Unit,
    modifier: Modifier = Modifier
) {
    // TODO 2 : Implémentez le NavHost ici
}
