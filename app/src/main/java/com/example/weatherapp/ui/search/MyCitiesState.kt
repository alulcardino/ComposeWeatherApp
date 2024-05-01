package com.example.weatherapp.ui.search

import com.example.weatherapp.domain.model.MyCity

sealed interface MyCitiesState {
    data class Success(val forecast: List<MyCity>?): MyCitiesState
    data class Error(val errorMessage: String?): MyCitiesState

    object Loading: MyCitiesState
}