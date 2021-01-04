package com.example.androidx.ui.home.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.androidx.ARGUMENT_KEY_1
import com.example.androidx.ARGUMENT_KEY_2
import com.example.androidx.ARGUMENT_KEY_3
import com.example.androidx.R

class Home1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val textView: TextView = root.findViewById(R.id.text_home)
        textView.text = "Page 1"

        val button = root.findViewById<Button>(R.id.button_next)
        button.setOnClickListener {
            val args = bundleOf(
                ARGUMENT_KEY_1 to 1,
                ARGUMENT_KEY_2 to "test",
            )
            findNavController().navigate(R.id.action_home1_to_home2, args)
        }

        return root
    }
}