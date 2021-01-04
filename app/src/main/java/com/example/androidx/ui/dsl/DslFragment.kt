package com.example.androidx.ui.dsl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.androidx.R

class DslFragment : Fragment() {

    private lateinit var dslViewModel: DslViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dslViewModel =
                ViewModelProvider(this).get(DslViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dsl, container, false)

        val textView: TextView = root.findViewById(R.id.text_dsl)
        dslViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val button = root.findViewById<Button>(R.id.button_next)
        button.setOnClickListener {
            findNavController().navigate(R.id.to_dslActivity)
            // findNavController().navigate(NotificationsFragmentDirections.toNotifications1WithoutParams())
//            findNavController().navigate(NotificationsFragmentDirections.toNotifications1WithParams(arg2 = 78))
        }

        return root
    }
}