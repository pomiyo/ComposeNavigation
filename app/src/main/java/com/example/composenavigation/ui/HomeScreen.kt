package com.example.composenavigation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {

    Column {
        Text("HOME SCREEN")

        Button(onClick = {
            navController.navigate(Screen.Home1.route)
        }) {
            Text("Go to Home1")
        }
    }
}