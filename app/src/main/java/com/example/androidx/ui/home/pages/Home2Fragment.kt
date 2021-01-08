package com.example.androidx.ui.home.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.androidx.ARGUMENT_KEY_3
import com.example.androidx.R
import com.example.androidx.databinding.FragmentHomeBinding

class Home2Fragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        // Override back pressed event
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Pop fragments BackStack examples
//            findNavController().popBackStack()
//            findNavController().popBackStack(R.id.homeFragment, false)
        }

        binding.textDescription.text = "Page 2"
        binding.buttonNext.setOnClickListener {

            val args = arguments ?: Bundle()
            args.putAll(
                bundleOf(
                    ARGUMENT_KEY_3 to 45.8,
                )
            )

            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_from_right)
                .setExitAnim(R.anim.slide_out_to_left)
                .setPopEnterAnim(R.anim.slide_in_from_left)
                .setPopExitAnim(R.anim.slide_out_to_right)
                .setPopUpTo(R.id.homeFragment, false)
                .build()

            findNavController().navigate(R.id.action_home2_to_home3, args, navOptions)
        }

        return binding.root
    }
}