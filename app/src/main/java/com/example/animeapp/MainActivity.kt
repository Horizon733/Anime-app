package com.example.animeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.navigation.compose.rememberNavController
import com.example.animeapp.presentation.components.BottomNavigationBar
import com.example.animeapp.presentation.util.BottomNavItem
import com.example.animeapp.presentation.util.Navigation
import com.example.animeapp.ui.theme.AnimeAppTheme

class MainActivity : ComponentActivity() {

    private val bottomNavigationItem = listOf(
        BottomNavItem(
            name = "Home",
            route = "home",
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            name = "Search",
            route = "search",
            icon = Icons.Default.Search
        ),
        BottomNavItem(
            name = "Profile",
            route = "profile",
            icon = Icons.Default.Person
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = bottomNavigationItem,
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}