package td.cadet.todochad.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TacheEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TodoChadDatabase : RoomDatabase() {
    abstract fun tacheDao(): TacheDao
}
