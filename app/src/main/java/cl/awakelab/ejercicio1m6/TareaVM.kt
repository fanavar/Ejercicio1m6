package cl.awakelab.ejercicio1m6

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TareaVM(aplicacion: Application): AndroidViewModel(aplicacion) {
    private val repositorio: Repositorio
    init {
        repositorio = Repositorio(TareaBdd.getDatabase(aplicacion).getTareaDao())
    }
    fun obtenerTareas(): LiveData<List<Tarea>> {
        return repositorio.getTareas()
    }
    fun insertarTareas(tarea: Tarea) = viewModelScope.launch{
        repositorio.insertTarea(tarea)
    }
}