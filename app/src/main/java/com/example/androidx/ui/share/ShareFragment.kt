package com.example.androidx.ui.share

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.androidx.ARGUMENT_KEY_1
import com.example.androidx.R
import com.example.androidx.TAG
import com.example.androidx.databinding.FragmentShareBinding

class ShareFragment : Fragment() {

    private val viewModel: ShareViewModel by navGraphViewModels(R.id.main_navigation)
    private lateinit var binding: FragmentShareBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShareBinding.inflate(layoutInflater)

        // Receive result from fragment
        val backStackStateHandler = findNavController().currentBackStackEntry?.savedStateHandle
        backStackStateHandler?.getLiveData<String>(
            ARGUMENT_KEY_1
        )?.observe(viewLifecycleOwner) { result ->
            Log.d(TAG, "Result: $result")
        }

        // ViewModel
        viewModel.run {
            resetCount()
            text.observe(viewLifecycleOwner) {
                binding.textDescription.text = it
            }
        }

        binding.buttonNext.setOnClickListener {
            viewModel.incrementCount()
            findNavController().navigate(ShareFragmentDirections.toShare1())
        }

        return binding.root
    }
}