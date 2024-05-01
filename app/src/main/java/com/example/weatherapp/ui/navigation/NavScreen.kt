package com.example.weatherapp.ui.navigation

sealed class NavScreen(val route: String) {
    object HomeScreen : NavScreen(NavRoutes.homeScreen)
    object SearchCityScreen : NavScreen(NavRoutes.searchCityScreen)
}
