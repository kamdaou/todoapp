package td.cadet.todochad.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import td.cadet.todochad.model.Tache

@Composable
fun TaskItem(
    tache: Tache,
    onToggleTerminee: (Tache) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Checkbox(
                checked = tache.terminee,
                onCheckedChange = { onToggleTerminee(tache) }
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = tache.titre,
                    fontWeight = FontWeight.Bold,
                    textDecoration = if (tache.terminee) TextDecoration.LineThrough else null
                )
                if (tache.description.isNotBlank()) {
                    Text(
                        text = tache.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
