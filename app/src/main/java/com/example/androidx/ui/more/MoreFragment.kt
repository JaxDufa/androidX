package com.example.androidx.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.androidx.R
import com.example.androidx.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private val moreViewModel: MoreViewModel by viewModels()
    private lateinit var binding: FragmentMoreBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoreBinding.inflate(layoutInflater)

        moreViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textDescription.text = it
        })

        binding.buttonNext.setOnClickListener {
            findNavController().navigate(R.id.to_dslActivity)
        }

        // DSL
        // COMPOSE
        // Multiple Stacks (Bottom Navigation)

        return binding.root
    }
}