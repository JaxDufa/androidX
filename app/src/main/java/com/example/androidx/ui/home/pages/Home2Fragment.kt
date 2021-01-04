package com.example.androidx.ui.home.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.androidx.ARGUMENT_KEY_1
import com.example.androidx.ARGUMENT_KEY_2
import com.example.androidx.ARGUMENT_KEY_3
import com.example.androidx.R

class Home2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        requireActivity().onBackPressedDispatcher.addCallback(this) {

        }


        val textView: TextView = root.findViewById(R.id.text_home)
        textView.text = "Page 2"

        val button = root.findViewById<Button>(R.id.button_next)
        button.setOnClickListener {

            val args = arguments ?: Bundle()
            args.putAll(
                bundleOf(
                    ARGUMENT_KEY_3 to 45.8,
                )
            )

            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.nav_default_enter_anim)
                .setExitAnim(R.anim.nav_default_exit_anim)
                .build()

            findNavController().navigate(R.id.action_home2_to_home3, args, navOptions)
        }

        return root
    }
}