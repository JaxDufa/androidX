package com.example.androidx.ui.share.pages

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.androidx.ARGUMENT_KEY_1
import com.example.androidx.R
import com.example.androidx.REQUEST_KEY_1
import com.example.androidx.TAG
import com.example.androidx.ui.share.ShareViewModel

class Share1Fragment : Fragment() {

    private val viewModel: ShareViewModel by navGraphViewModels(R.id.main_navigation)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_share, container, false)

        // Override back pressed event
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            viewModel.decrementCount()
            findNavController().popBackStack()
        }

        // Set result to previous fragment (BackStack)
        findNavController().previousBackStackEntry?.savedStateHandle?.set(
            ARGUMENT_KEY_1,
            findNavController().currentDestination?.label
        )

        // ViewModel
        viewModel.text.observe(viewLifecycleOwner) {
            root.findViewById<TextView>(R.id.text_share).text = it
        }

        root.findViewById<Button>(R.id.button_next).setOnClickListener {
            viewModel.incrementCount()
            findNavController().navigate(Share1FragmentDirections.toShare2())
        }

        return root
    }
}