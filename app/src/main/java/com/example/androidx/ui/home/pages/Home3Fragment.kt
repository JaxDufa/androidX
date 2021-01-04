package com.example.androidx.ui.home.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidx.R

class Home3Fragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val textView: TextView = root.findViewById(R.id.text_home)
        textView.text = "Page 3"

        val button = root.findViewById<Button>(R.id.button_next)
        button.text = "Nested"
        button.setOnClickListener {
            findNavController().navigate(R.id.action_home3_to_feature_navigation)
            //findNavController().popBackStack(R.id.navigation_home, false)
        }

        return root
    }
}