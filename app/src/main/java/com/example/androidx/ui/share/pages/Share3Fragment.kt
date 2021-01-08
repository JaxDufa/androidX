package com.example.androidx.ui.share.pages

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.androidx.ARGUMENT_KEY_2
import com.example.androidx.R
import com.example.androidx.REQUEST_KEY_2
import com.example.androidx.TAG
import com.example.androidx.databinding.FragmentShareBinding
import com.example.androidx.ui.share.ShareViewModel

class Share3Fragment : Fragment() {

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

        // Listen for Fragment request result
        setFragmentResultListener(REQUEST_KEY_2) { requestKey, bundle ->
            val result = bundle.getInt(ARGUMENT_KEY_2)
            Log.d(TAG, "Request result: $result")
        }

        // ViewModel
        viewModel.text.observe(viewLifecycleOwner) {
            binding.textDescription.text = it
        }

        // Button
        binding.buttonNext.setOnClickListener {
            viewModel.incrementCount()
            findNavController().navigate(Share3FragmentDirections.toShare4())
        }

        return binding.root
    }
}