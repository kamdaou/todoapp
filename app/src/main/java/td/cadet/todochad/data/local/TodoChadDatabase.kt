package td.cadet.todochad.data.local

// ==========================================================
// TODO 3 — Créer la classe Database Room
// ==========================================================
//
// C'est la classe centrale de Room : elle connecte les Entity
// aux DAO et gère la création/migration de la base SQLite.
//
// Créez la classe suivante :
//
//   @Database(
//       entities = [TacheEntity::class],
//       version = 1,
//       exportSchema = false
//   )
//   abstract class TodoChadDatabase : RoomDatabase() {
//       abstract fun tacheDao(): TacheDao
//   }
//
// Points importants :
//   - @Database liste toutes les Entity de votre base
//   - version = 1 : numéro de version du schéma
//   - La classe est abstract car Room génère l'implémentation
//   - Elle déclare des méthodes abstract pour accéder aux DAO
//
// Imports nécessaires :
//   - androidx.room.Database
//   - androidx.room.RoomDatabase
//
// Note : on ne crée PAS l'instance ici. L'instanciation se fait
// dans MainActivity avec Room.databaseBuilder (voir TODO 7).
// ==========================================================
