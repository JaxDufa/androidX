package com.example.androidx.ui.safe.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidx.MainNavigationDirections
import com.example.androidx.databinding.FragmentSafeBinding

class Safe3Fragment : Fragment() {

    private lateinit var binding: FragmentSafeBinding

    // Receive arguments from previous fragment (When arguments are defined inside the fragment tag)
    private val args: Safe3FragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSafeBinding.inflate(layoutInflater)

        binding.textDescription.text = "Safe 3 - ${args.arg2}"

        // Can be converted to Bundle
//        val bundleArgs = args.toBundle()

        binding.buttonNext.setOnClickListener {
            findNavController().navigate(MainNavigationDirections.actionGlobalToFeature1Fragment())
        }

        return binding.root
    }
}