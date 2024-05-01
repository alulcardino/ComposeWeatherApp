package com.example.weatherapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.home.HomeScreen
import com.example.weatherapp.ui.home.HomeViewModel
import com.example.weatherapp.ui.search.SearchCityScreen
import com.example.weatherapp.ui.search.SearchCityViewModel

@Composable
fun NavGraph(
    startDestination: String = NavScreen.HomeScreen.route,
    homeViewModel: HomeViewModel,
    searchCityViewModel: SearchCityViewModel
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = startDestination
        ) {
            composable(NavScreen.HomeScreen.route) {
                HomeScreen(homeViewModel) { navController.navigate(NavScreen.SearchCityScreen.route) }
            }
            composable(NavScreen.SearchCityScreen.route) {
                SearchCityScreen(searchCityViewModel) {
                    navController.navigate(NavScreen.HomeScreen.route) {
                        launchSingleTop = true
                        popUpTo(NavScreen.HomeScreen.route)
                    }
                }
            }
        }
    }
}