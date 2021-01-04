package com.example.androidx.ui.share

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

class ShareFragment : Fragment() {

    private lateinit var shareViewModel: ShareViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        shareViewModel =
                ViewModelProvider(this).get(ShareViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_share, container, false)

        val textView: TextView = root.findViewById(R.id.text_dashboard)
        shareViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val button = root.findViewById<Button>(R.id.button_next)
        button.setOnClickListener {
            findNavController().navigate(ShareFragmentDirections.toShare1())
        }

        return root
    }
}