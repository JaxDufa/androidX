package com.example.androidx

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

// - Navigation https://developer.android.com/guide/navigation/navigation-principles
// - Graph and actions with pop  https://developer.android.com/guide/navigation/navigation-design-graph
// - Animations https://developer.android.com/guide/navigation/navigation-animate-transitions
// - Custom back navigation https://developer.android.com/guide/navigation/navigation-custom-back
// - Deep Link https://developer.android.com/guide/navigation/navigation-deep-link
// - Nested graph https://developer.android.com/guide/navigation/navigation-nested-graphs

// - Safe Args https://developer.android.com/guide/navigation/navigation-pass-data
// - Global Actions https://developer.android.com/guide/navigation/navigation-global-action

// - Share data with ViewModel https://developer.android.com/guide/fragments/communicate#viewmodel
// - Fragments result https://developer.android.com/guide/fragments/communicate#fragment-result

// - Nav DSL https://developer.android.com/guide/navigation/navigation-kotlin-dsl
// - Nav compose https://developer.android.com/jetpack/compose/navigation
// - Multiple Stacks https://github.com/android/architecture-components-samples/blob/master/NavigationAdvancedSample/app/src/main/java/com/example/android/navigationadvancedsample/NavigationExtensions.kt

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavView: BottomNavigationView = findViewById(R.id.nav_view)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.safeFragment,
                R.id.shareFragment,
                R.id.moreFragment
            )
        )

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            val id = destination.id
            val label = destination.label
            val args = arguments?.toString()
            Log.d(TAG, "Destination changed \n Id: $id \n Label: $label \n Arguments: $args")
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        // return navController.navigateUp() || super.onSupportNavigateUp()
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}