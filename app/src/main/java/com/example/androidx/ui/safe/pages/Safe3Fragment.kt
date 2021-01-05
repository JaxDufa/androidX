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
import com.example.androidx.MainNavigationDirections
import com.example.androidx.R

class Safe3Fragment : Fragment() {

    // Receive arguments from previous fragment (When arguments are defined inside the fragment tag)
    private val args: Safe3FragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_safe, container, false)

        val textView: TextView = root.findViewById(R.id.text_notifications)
        textView.text = "Safe 3 - ${args.arg2}"

        // Can be converted to Bundle
        val bundleArgs = args.toBundle()

        val button = root.findViewById<Button>(R.id.button_next)
        button.setOnClickListener {
            findNavController().navigate(MainNavigationDirections.actionGlobalToFeature1Fragment())
        }

        return root
    }
}