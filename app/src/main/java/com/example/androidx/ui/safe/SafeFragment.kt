package com.example.androidx.ui.safe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.androidx.R

class SafeFragment : Fragment() {

    private val safeViewModel: SafeViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_safe, container, false)

        val textView: TextView = root.findViewById(R.id.text_notifications)
        safeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val button = root.findViewById<Button>(R.id.button_next)
        button.setOnClickListener {
            findNavController().navigate(SafeFragmentDirections.actionSafeToSafe1())
        }

        return root
    }
}