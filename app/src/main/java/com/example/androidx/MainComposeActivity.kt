package com.example.androidx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// https://blog.mindorks.com/jetpack-compose-navigation

//class MainComposeActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            ComposeNavigationTheme {
//                ComposeNavigation()
//            }
//        }
//    }
//
//    @Composable
//    fun ComposeNavigation() {
//        val navController = rememberNavController()
//        NavHost(
//            navController = navController,
//            startDestination = "screen1"
//        ) {
//            composable("screen1") {
//                FirstScreen(navController = navController)
//            }
//            composable("screen2") {
//                SecondScreen(navController = navController)
//            }
//            composable(
//                "screen3/{id}",
//                arguments = listOf(navArgument("id") { type = NavType.StringType }) {
//                    ThirdScreen(navController = navController)
//                }
//        }
//    }
//
//    @Composable
//    fun FirstScreen(navController: NavController) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "First Screen",
//                color = Color.Green,
//                style = TextStyle(textAlign = TextAlign.Center),
//                modifier = Modifier.padding(24.dp).clickable(onClick = {
//                    navController.navigate("screen2")
//                })
//            )
//        }
//    }
//
//    @Composable
//    fun SecondScreen(navController: NavController) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "Second Screen",
//                color = Color.Yellow,
//                style = TextStyle(textAlign = TextAlign.Center),
//                modifier = Modifier.clickable(onClick = {
//                    navController.navigate("screen3/1234")
//                })
//            )
//        }
//    }
//
//    @Composable
//    fun ThirdScreen(navController: NavController) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "Third Screen",
//                color = Color.Red,
//                style = TextStyle(textAlign = TextAlign.Center),
//                modifier = Modifier.clickable(onClick = {
//                    navController.navigate("screen1") {
//                        popUpTo("screen2") { inclusive = true }
//                    }
//                })
//            )
//        }
//    }
//}