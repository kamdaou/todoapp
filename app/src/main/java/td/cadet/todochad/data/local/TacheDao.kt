package td.cadet.todochad.data.local

// ==========================================================
// TODO 2 — Créer le DAO (Data Access Object)
// ==========================================================
//
// Le DAO est une interface qui définit les opérations sur la
// base de données. Room génère l'implémentation automatiquement.
//
// Créez l'interface suivante :
//
//   @Dao
//   interface TacheDao {
//
//       @Query("SELECT * FROM taches ORDER BY dateCreation DESC")
//       fun getAllTaches(): Flow<List<TacheEntity>>
//
//       @Query("SELECT * FROM taches WHERE id = :id")
//       fun getTacheById(id: Int): Flow<TacheEntity?>
//
//       @Insert
//       suspend fun insert(tache: TacheEntity)
//
//       @Update
//       suspend fun update(tache: TacheEntity)
//
//       @Delete
//       suspend fun delete(tache: TacheEntity)
//   }
//
// Points importants :
//   - Les méthodes SELECT retournent Flow<...> pour être réactives
//     (la UI se met à jour automatiquement quand la BD change)
//   - Les méthodes INSERT/UPDATE/DELETE sont "suspend" car elles
//     doivent tourner dans une coroutine (pas sur le thread UI)
//   - @Query prend du SQL en paramètre
//
// Annotations à utiliser :
//   - @Dao, @Query, @Insert, @Update, @Delete (androidx.room)
//
// Imports nécessaires :
//   - androidx.room.*
//   - kotlinx.coroutines.flow.Flow
// ==========================================================
