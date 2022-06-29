package es.ipow.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import es.ipow.navigation.databinding.FragmentInitBinding

class InitFragment : Fragment() {
    private var _b: FragmentInitBinding? = null
    private val b get() = _b!!
    private var cont = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _b = FragmentInitBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b.tvCont.setOnClickListener {
            cont++
            b.tvCont.setText(cont.toString())
        }
        // Navegación SIN Safe Args
        b.btnFragment1.setOnClickListener {
            val bundle = bundleOf("Contador" to cont.toString())
            view.findNavController().navigate(R.id.action_initFragment_to_firstFragment, bundle)
            // Navigation.createNavigateOnClickListener(R.id.firstFragment,null)
        }
        // Navegación CON Safe Args
        b.btnFragment2.setOnClickListener {
            val action = InitFragmentDirections.actionInitFragmentToSecondFragment(cont)
            view.findNavController().navigate(action)
        }
    }
}