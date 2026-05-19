package td.cadet.todochad.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TacheDao {

    @Query("SELECT * FROM taches ORDER BY dateCreation DESC")
    fun getAllTaches(): Flow<List<TacheEntity>>

    @Query("SELECT * FROM taches WHERE id = :id")
    fun getTacheById(id: Int): Flow<TacheEntity?>

    @Insert
    suspend fun insert(tache: TacheEntity)

    @Update
    suspend fun update(tache: TacheEntity)

    @Delete
    suspend fun delete(tache: TacheEntity)
}
