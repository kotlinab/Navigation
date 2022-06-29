package es.ipow.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import es.ipow.navigation.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _b:FragmentFirstBinding? = null
    private val b get() = _b!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _b = FragmentFirstBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b.tvCont1.setText(arguments?.getString("Contador"))
        b.btnBack1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.initFragment)
        }
    }
}