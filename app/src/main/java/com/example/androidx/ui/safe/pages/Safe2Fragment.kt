package com.example.androidx.ui.safe.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidx.databinding.FragmentSafeBinding

class Safe2Fragment : Fragment() {

    private lateinit var binding: FragmentSafeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSafeBinding.inflate(layoutInflater)

        binding.textDescription.text = "Safe 2"
        binding.buttonNext.setOnClickListener {
            findNavController().navigate(Safe2FragmentDirections.toSafe3(arg2 = 78))
        }

        return binding.root
    }
}