package com.example.androidx.ui.share.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.androidx.ARGUMENT_KEY_1
import com.example.androidx.R
import com.example.androidx.databinding.FragmentShareBinding
import com.example.androidx.ui.share.ShareViewModel

class Share1Fragment : Fragment() {

    private val viewModel: ShareViewModel by navGraphViewModels(R.id.main_navigation)
    private lateinit var binding: FragmentShareBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShareBinding.inflate(layoutInflater)

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

        // Retrieve a specific entry from BackStack (Util when using dialogs)
//        val navBackStackEntry = findNavController().getBackStackEntry(R.id.your_fragment)
//        navBackStackEntry.savedStateHandle.get<String>("key")

        // ViewModel
        viewModel.text.observe(viewLifecycleOwner) {
            binding.textDescription.text = it
        }

        // Button
        binding.buttonNext.setOnClickListener {
            viewModel.incrementCount()
            findNavController().navigate(Share1FragmentDirections.toShare2())
        }

        return binding.root
    }
}