package cl.awakelab.ejercicio1m6

import androidx.room.Insert

interface TareaDao {
    @Insert
    suspend fun insertarTarea(tarea: Tarea)
}