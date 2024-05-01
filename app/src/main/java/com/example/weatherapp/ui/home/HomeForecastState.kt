package com.example.weatherapp.ui.home

import com.example.weatherapp.domain.model.Forecast


sealed interface HomeForecastState {
    data class Success(val forecast: Forecast?): HomeForecastState
    data class Error(val errorMessage: String?): HomeForecastState

    object Loading: HomeForecastState
}