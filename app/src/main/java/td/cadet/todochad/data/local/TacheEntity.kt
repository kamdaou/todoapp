package td.cadet.todochad.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import td.cadet.todochad.model.Tache

@Entity(tableName = "taches")
data class TacheEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titre: String,
    val description: String = "",
    val terminee: Boolean = false,
    val dateCreation: Long = System.currentTimeMillis(),
    val dateEcheance: Long? = null
)

fun TacheEntity.toTache() = Tache(id, titre, description, terminee)

fun Tache.toEntity() = TacheEntity(id, titre, description, terminee)
