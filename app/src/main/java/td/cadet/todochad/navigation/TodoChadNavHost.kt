package td.cadet.todochad.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import td.cadet.todochad.model.Tache
import td.cadet.todochad.ui.screens.AddTaskScreen
import td.cadet.todochad.ui.screens.DetailTaskScreen
import td.cadet.todochad.ui.screens.ListTasksScreen
import td.cadet.todochad.ui.screens.SettingsScreen

@Composable
fun TodoChadNavHost(
    taches: List<Tache>,
    onToggleTerminee: (Tache) -> Unit,
    onAjouterTache: (String, String) -> Unit,
    onSupprimerTache: (Tache) -> Unit,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ListTaches,
        modifier = modifier
    ) {
        composable<ListTaches> {
            ListTasksScreen(
                taches = taches,
                onToggleTerminee = onToggleTerminee,
                onAjouterClick = { navController.navigate(AjouterTache) },
                onTacheClick = { tache -> navController.navigate(DetailTache(tache.id)) },
                onParametresClick = { navController.navigate(Parametres) }
            )
        }

        composable<AjouterTache> {
            AddTaskScreen(
                onAjouter = { titre, description ->
                    onAjouterTache(titre, description)
                    navController.popBackStack()
                },
                onAnnuler = { navController.popBackStack() }
            )
        }

        composable<DetailTache> { backStackEntry ->
            val destination = backStackEntry.toRoute<DetailTache>()
            val tache = taches.find { it.id == destination.id }
            if (tache != null) {
                DetailTaskScreen(
                    tache = tache,
                    onToggleTerminee = onToggleTerminee,
                    onSupprimer = {
                        onSupprimerTache(tache)
                        navController.popBackStack()
                    },
                    onRetour = { navController.popBackStack() }
                )
            }
        }

        composable<Parametres> {
            SettingsScreen(
                onRetour = { navController.popBackStack() }
            )
        }
    }
}
