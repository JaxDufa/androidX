package com.example.androidx.ui.home.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidx.ARGUMENT_KEY_1
import com.example.androidx.ARGUMENT_KEY_2
import com.example.androidx.R
import com.example.androidx.databinding.FragmentHomeBinding

class Home1Fragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.textDescription.text = "Page 1"
        binding.buttonNext.setOnClickListener {
            // Creating args
            val args = bundleOf(
                ARGUMENT_KEY_1 to 1,
                ARGUMENT_KEY_2 to "test",
            )
            findNavController().navigate(R.id.action_home1_to_home2, args)
        }

        return binding.root
    }
}