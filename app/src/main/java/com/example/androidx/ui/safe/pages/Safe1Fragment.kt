package com.example.androidx.ui.safe.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidx.R
import com.example.androidx.ui.safe.SafeFragmentDirections

class Safe1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_safe, container, false)

        val textView: TextView = root.findViewById(R.id.text_notifications)
        textView.text = "Safe 1"

        val button = root.findViewById<Button>(R.id.button_next)
        button.setOnClickListener {
            //findNavController().navigate(Safe1FragmentDirections.toSafe2WithoutArgs())
            findNavController().navigate(Safe1FragmentDirections.toSafe2WithArgs("Unique ID"))
        }

        return root
    }
}