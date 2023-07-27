package cl.awakelab.ejercicio1m6

import androidx.room.Dao
import androidx.room.Insert
@Dao
interface TareaDao {
    @Insert
    suspend fun insertarTarea(tarea: Tarea)
}