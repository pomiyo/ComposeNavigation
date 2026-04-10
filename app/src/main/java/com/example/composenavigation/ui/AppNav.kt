package com.example.composenavigation.ui

import BottomNavBar
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNav() {
    val navController = rememberNavController()

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

            homeGraph(navController)
            composable(Screen.Search.route) { SimpleScreen("Search") }
            composable(Screen.Profile.route) { SimpleScreen("Profile") }
        }
    }
}

fun NavGraphBuilder.homeGraph(navController: NavHostController) {

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
}