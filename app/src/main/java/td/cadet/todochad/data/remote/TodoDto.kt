package td.cadet.todochad.data.remote

import kotlinx.serialization.Serializable
import td.cadet.todochad.data.local.TacheEntity

@Serializable
data class TodoDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

fun TodoDto.toTacheEntity() = TacheEntity(
    titre = title,
    description = "Importé depuis JSONPlaceholder (user $userId)",
    terminee = completed
)
