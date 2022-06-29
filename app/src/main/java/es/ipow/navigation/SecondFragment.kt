package es.ipow.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController

import es.ipow.navigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _b: FragmentSecondBinding? = null
    private val b get() = _b!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _b = FragmentSecondBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b.btnBack2.setOnClickListener (
            // { Navigation.findNavController(view).navigate(R.id.initFragment) }
            Navigation.createNavigateOnClickListener(R.id.initFragment, null)
        )
        b.btnForward2.setOnClickListener {
            view.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }
}