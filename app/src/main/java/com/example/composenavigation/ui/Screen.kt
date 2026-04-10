package com.example.composenavigation.ui

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Home1 : Screen("home1")
    object Home2 : Screen("home2")

    object Search : Screen("search")
    object Profile : Screen("profile")
}