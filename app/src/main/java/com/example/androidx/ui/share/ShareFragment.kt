package com.example.androidx.ui.share

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.androidx.ARGUMENT_KEY_1
import com.example.androidx.R
import com.example.androidx.TAG

class ShareFragment : Fragment() {

    private val viewModel: ShareViewModel by navGraphViewModels(R.id.main_navigation)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_share, container, false)

        // Receive result from fragment
        val backStackStateHandler = findNavController().currentBackStackEntry?.savedStateHandle
        backStackStateHandler?.getLiveData<String>(
            ARGUMENT_KEY_1
        )?.observe(viewLifecycleOwner) { result ->
            Log.d(TAG, "Result: $result")
        }

        // ViewModel
        viewModel.run {
            resetCount()
            text.observe(viewLifecycleOwner) {
                root.findViewById<TextView>(R.id.text_share).text = it
            }
        }

        root.findViewById<Button>(R.id.button_next).setOnClickListener {
            viewModel.incrementCount()
            findNavController().navigate(ShareFragmentDirections.toShare1())
        }

        return root
    }
}