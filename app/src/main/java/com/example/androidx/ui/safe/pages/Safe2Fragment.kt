package com.example.androidx.ui.safe.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidx.R

class Safe2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_safe, container, false)

        val textView: TextView = root.findViewById(R.id.text_notifications)
        textView.text = "Safe 2"

        val button = root.findViewById<Button>(R.id.button_next)
        button.setOnClickListener {
//            findNavController().navigate(Safe2FragmentDirections.toSafe3WithoutParams())
            findNavController().navigate(Safe2FragmentDirections.toSafe3(arg2 = 78))
        }

        return root
    }
}