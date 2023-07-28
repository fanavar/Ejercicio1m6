package cl.awakelab.ejercicio1m6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import cl.awakelab.ejercicio1m6.databinding.FragmentAgregarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AgregarFragment : Fragment() {
    lateinit var binding: FragmentAgregarBinding
    private val tareaVM: TareaVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgregarBinding.inflate(layoutInflater, container, false)
        initListener()
        loadTareas()
        return binding.root
    }

    private fun initListener() {
        binding.btnAgregar.setOnClickListener {
            val texto = binding.etAgregar.text.toString()
            guardarTarea(texto)
            binding.etAgregar.setText("")
            Toast.makeText(requireContext(), "Se ha agregado un texto", Toast.LENGTH_LONG).show()
        }
    }

    private fun guardarTarea(texto: String) {

        val tarea = Tarea(texto)
       tareaVM.insertarTareas(tarea)
    }

    private fun loadTareas() {


           tareaVM.obtenerTareas().observe(viewLifecycleOwner){

                val tareaAsText = it.joinToString("\n") { it.nombre }
                binding.tvAgregar.text = tareaAsText
            }



    }

}