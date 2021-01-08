package com.example.androidx

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.androidx.ui.feature.Feature1Fragment
import com.example.androidx.ui.feature.FeatureFragment
import com.example.androidx.ui.feature.feature_graph

class MainDslActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dsl)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        Log.d(TAG, "Creating graph")
        navController.apply {
            graph = createGraph(feature_graph.id, feature_graph.dest.feature) {

                fragment<FeatureFragment>(feature_graph.dest.feature) {
                    label = "Feature"
                    action(feature_graph.action.to_feature1) {
                        destinationId = feature_graph.dest.feature1
                    }
                }

                fragment<Feature1Fragment>(feature_graph.dest.feature1) {
                    label = "Feature1"
                    argument(feature_graph.args.id) {
                        type = NavType.StringType
                    }
                }
            }
        }

        navController.addOnDestinationChangedListener { _, destination, arguments ->
            val id = destination.id
            val label = destination.label
            val args = arguments?.toString()
            Log.d(TAG, "Destination changed \n Id: $id \n Label: $label \n Arguments: $args")
        }

        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}