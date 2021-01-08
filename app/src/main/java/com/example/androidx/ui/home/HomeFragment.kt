package com.example.androidx.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.androidx.R
import com.example.androidx.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textDescription.text = it
        })

        binding.buttonNext.setOnClickListener {
//            NavHostFragment.findNavController(this)
            findNavController().navigate(R.id.action_home_to_home1)
        }

        return binding.root
    }
}