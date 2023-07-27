package cl.awakelab.ejercicio1m6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.awakelab.ejercicio1m6.databinding.FragmentAgregarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AgregarFragment : Fragment() {
    lateinit var binding: FragmentAgregarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgregarBinding.inflate(layoutInflater, container, false)
        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.btnAgregar.setOnClickListener{
            val texto = binding.etAgregar.text.toString()
            guardarTarea(texto)
        }
    }

    private fun guardarTarea(texto: String) {
       val dao = TareaBdd.getDatabase(requireContext()).getTareaDao()
       val tarea = Tarea(texto )
       GlobalScope.launch { dao.insertarTarea(tarea) }
    }


}