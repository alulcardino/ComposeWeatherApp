package com.example.weatherapp.ui.main

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.weatherapp.core.designsystem.theme.ComposeWeatherAppTheme
import com.example.weatherapp.ui.home.HomeViewModel
import com.example.weatherapp.ui.navigation.NavGraph
import com.example.weatherapp.ui.search.SearchCityViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel:  HomeViewModel by viewModels()
    private val searchCityViewModel: SearchCityViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            homeViewModel.loadLocation()
        }
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            )
        )

        setContent {
            ComposeWeatherAppTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(color = Color.Transparent)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    NavGraph(
                        homeViewModel = homeViewModel,
                        searchCityViewModel = searchCityViewModel
                    )
                }
            }
        }
    }
}