package com.example.androidx.ui.home.pages

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.example.androidx.R
import com.example.androidx.databinding.FragmentHomeBinding

class Home3Fragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.textDescription.text = "Page 3"
        binding.buttonNext.apply {
            setOnClickListener {
                findNavController().navigate(R.id.action_home3_to_feature_navigation)
            }
        }

        binding.buttonDeepLink.apply {
            visibility = View.VISIBLE
            setOnClickListener {
//                findNavController().navigate(Uri.parse("navigation://feature"))
                triggerDeepLink()
            }
        }

        return binding.root
    }

    private fun triggerDeepLink() {
        val deepLinkRequest = NavDeepLinkRequest.Builder
            .fromUri(Uri.parse("navigation://feature"))
            .setAction("android.intent.action.MY_ACTION")
            .setMimeType("type/subtype")
            .build()
        findNavController().navigate(deepLinkRequest)

        // Expose the graph DeepLinks inside AndroidManifest
//        <activity name=".MainActivity" ...>
//            ...
//
//            <nav-graph android:value="@navigation/nav_graph" />
//
//            ...
//        </activity>
    }
}