package com.example.androidx.ui.home.pages

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

class Home3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val textView: TextView = root.findViewById(R.id.text_home)
        textView.text = "Page 3"

        root.findViewById<Button>(R.id.button_next).apply {
            setOnClickListener {
                findNavController().navigate(R.id.action_home3_to_feature_navigation)
            }
        }

        root.findViewById<Button>(R.id.button_deep_link).apply {
            visibility = View.VISIBLE
            setOnClickListener {
                findNavController().navigate(Uri.parse("navigation://feature"))
            }
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