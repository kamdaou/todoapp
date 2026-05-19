package td.cadet.todochad.data.remote

// ==========================================================
// TODO 2 — Créer le DTO (Data Transfer Object) pour l'API
// ==========================================================
//
// Un DTO représente la structure JSON retournée par l'API.
// On utilise kotlinx.serialization pour convertir JSON ↔ Kotlin.
//
// Le JSON de JSONPlaceholder ressemble à :
//   {
//     "userId": 1,
//     "id": 1,
//     "title": "delectus aut autem",
//     "completed": false
//   }
//
// Créez la data class suivante :
//
//   @Serializable
//   data class TodoDto(
//       val userId: Int,
//       val id: Int,
//       val title: String,
//       val completed: Boolean
//   )
//
// Puis ajoutez une fonction de conversion vers TacheEntity :
//
//   fun TodoDto.toTacheEntity() = TacheEntity(
//       id = id,
//       titre = title,
//       description = "Importé depuis JSONPlaceholder (user $userId)",
//       terminee = completed
//   )
//
// Imports nécessaires :
//   - kotlinx.serialization.Serializable
//   - td.cadet.todochad.data.local.TacheEntity
// ==========================================================
