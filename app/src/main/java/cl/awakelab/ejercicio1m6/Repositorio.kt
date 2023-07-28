package cl.awakelab.ejercicio1m6

import androidx.lifecycle.LiveData

class Repositorio(private val tareaDao: TareaDao) {
    suspend fun insertTarea(tarea: Tarea){
        tareaDao.insertarTarea(tarea)
    }
    fun getTareas(): LiveData<List<Tarea>>{
        return tareaDao.getTareas()

    }
}