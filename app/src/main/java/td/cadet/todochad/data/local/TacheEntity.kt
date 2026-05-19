package td.cadet.todochad.data.local

// ==========================================================
// TODO 1 — Transformer la data class Tache en Entity Room
// ==========================================================
//
// Room a besoin d'annotations pour savoir comment stocker
// vos objets dans une base SQLite.
//
// Créez une Entity "TacheEntity" avec les champs suivants :
//
//   @Entity(tableName = "taches")
//   data class TacheEntity(
//       @PrimaryKey(autoGenerate = true)
//       val id: Int = 0,
//       val titre: String,
//       val description: String = "",
//       val terminee: Boolean = false,
//       val dateCreation: Long = System.currentTimeMillis(),
//       val dateEcheance: Long? = null
//   )
//
// Annotations à utiliser :
//   - @Entity(tableName = "taches") : déclare la table
//   - @PrimaryKey(autoGenerate = true) : id auto-incrémenté
//
// Imports nécessaires :
//   - androidx.room.Entity
//   - androidx.room.PrimaryKey
//
// Note : on crée une TacheEntity séparée du modèle Tache
// pour séparer la couche données de la couche UI.
// Ajoutez aussi des fonctions de conversion :
//
//   fun TacheEntity.toTache() = Tache(id, titre, description, terminee)
//   fun Tache.toEntity() = TacheEntity(id, titre, description, terminee)
//
// (import td.cadet.todochad.model.Tache)
// ==========================================================
