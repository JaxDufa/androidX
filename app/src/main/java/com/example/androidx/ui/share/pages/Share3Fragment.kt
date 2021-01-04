package com.example.androidx.ui.share.pages

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidx.R

class Share3Fragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_share, container, false)

        val textView: TextView = root.findViewById(R.id.text_dashboard)
        textView.text = "Share 3"

        val button = root.findViewById<Button>(R.id.button_next)
        button.text = "Nested"
        button.setOnClickListener {
            findNavController().navigate(Uri.parse("navigation://feature"))
        }

        return root
    }

//    private fun triggerDeepLink() {
//        val pendingIntent = NavDeepLinkBuilder(requireContext())
//            .setGraph(R.navigation.mobile_navigation)
//            .setDestination(R.id.featureFragment)
//            .setArguments(Bundle())
//            .createPendingIntent()
//
//        pendingIntent.send()
//    }
}