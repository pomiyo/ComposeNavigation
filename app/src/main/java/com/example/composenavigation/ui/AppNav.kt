package com.example.composenavigation.ui

import BottomNavBar
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNav() {
    val navController = rememberNavController()

    val context = LocalContext.current

//    BackHandler {
//
//        val isAtRoot = navController.currentDestination?.route in listOf(
//            "home",
//            "search"
//        )
//
//
//        if (isAtRoot) {
//            (context as? Activity)?.finish() // exit app
//        } else {
//            navController.popBackStack()
//        }
//    }

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "home_graph",
            modifier = Modifier.padding(padding)
        ) {

            navigation(
                startDestination = Screen.Home.route,
                route = "home_graph"
            ) {

                composable(Screen.Home.route) {
                    HomeScreen(navController)
                }

                composable(Screen.Home1.route) {
                    SimpleScreen("Home1")
                }

                composable(Screen.Home2.route) {
                    SimpleScreen("Home2")
                }
            }

            navigation(
                route = "search_graph",
                startDestination = "search"
            ) {
                composable("search") {
                    SimpleScreen("Search") {
                        navController.navigate("my_dialog")
                    }
                }

                dialog("my_dialog") {
                    MyDialog(
                        onDismiss = {
                            navController.popBackStack()
                        }
                    )
                }
            }

            composable(Screen.Profile.route) { SimpleScreen("Profile") }
        }
    }

}