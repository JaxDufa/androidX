package com.example.androidx.ui.feature

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
import com.example.androidx.MainActivity
import com.example.androidx.R

class FeatureFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        textView.text = "Feature"

        val button = root.findViewById<Button>(R.id.button_next)
        button.setOnClickListener {
            if (requireActivity() is MainActivity) {
                findNavController().navigate(R.id.action_featureFragment_to_feature1Fragment)
            } else {
                findNavController().navigate(feature_graph.action.to_feature1)
            }
        }

        return root
    }
}