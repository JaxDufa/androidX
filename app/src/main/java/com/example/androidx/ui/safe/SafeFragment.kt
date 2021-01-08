package com.example.androidx.ui.safe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.androidx.databinding.FragmentSafeBinding

class SafeFragment : Fragment() {

    private val safeViewModel: SafeViewModel by viewModels()
    private lateinit var binding: FragmentSafeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentSafeBinding.inflate(layoutInflater)

        safeViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textDescription.text = it
        })

        binding.buttonNext.setOnClickListener {
            findNavController().navigate(SafeFragmentDirections.actionSafeToSafe1())
        }

        return binding.root
    }
}