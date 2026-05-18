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
import td.cadet.todochad.ui.screens.AddTaskScreen
import td.cadet.todochad.ui.screens.ListTasksScreen
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

@Composable
fun TodoChadApp() {
    var taches by remember { mutableStateOf(listOf<Tache>()) }
    var ecranAjout by remember { mutableStateOf(false) }
    var prochainId by remember { mutableIntStateOf(1) }

    if (ecranAjout) {
        AddTaskScreen(
            onAjouter = { titre, description ->
                val nouvelleTache = Tache(
                    id = prochainId++,
                    titre = titre,
                    description = description
                )
                taches = taches + nouvelleTache
                ecranAjout = false
            },
            onAnnuler = { ecranAjout = false }
        )
    } else {
        ListTasksScreen(
            taches = taches,
            onToggleTerminee = { tache ->
                taches = taches.map {
                    if (it.id == tache.id) it.copy(terminee = !it.terminee) else it
                }
            },
            onAjouterClick = { ecranAjout = true }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TodoChadAppPreview() {
    TodoChadTheme {
        TodoChadApp()
    }
}
