package com.example.androidx.ui.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidx.MainActivity
import com.example.androidx.R
import com.example.androidx.databinding.FragmentHomeBinding

class FeatureFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.textDescription.text = "Feature"
        binding.buttonNext.setOnClickListener {
            if (requireActivity() is MainActivity) {
                findNavController().navigate(R.id.action_featureFragment_to_feature1Fragment)
            } else {
                findNavController().navigate(feature_graph.action.to_feature1)
            }
        }

        return binding.root
    }
}