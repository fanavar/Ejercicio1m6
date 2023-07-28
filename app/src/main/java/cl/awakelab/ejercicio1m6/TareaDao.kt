package cl.awakelab.ejercicio1m6

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TareaDao {
    @Insert
    suspend fun insertarTarea(tarea: Tarea)

    @Query("select * from tabla_tarea order by id ASC")
    fun getTareas(): LiveData<List<Tarea>>
}