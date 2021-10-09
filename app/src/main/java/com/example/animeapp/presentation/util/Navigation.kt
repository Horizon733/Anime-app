package com.example.animeapp.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.animeapp.presentation.HomeScreen
import com.example.animeapp.presentation.ProfileScreen
import com.example.animeapp.presentation.SearchScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home"){
            HomeScreen()
        }
        composable("search"){
            SearchScreen()
        }
        composable("profile"){
            ProfileScreen()
        }
    }
}