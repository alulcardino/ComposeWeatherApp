package com.example.weatherapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.core.Resource
import com.example.weatherapp.core.helpers.ExceptionTitles
import com.example.weatherapp.domain.model.City
import com.example.weatherapp.domain.model.Forecast
import com.example.weatherapp.domain.usecase.forecast.AddCityToDbUseCase
import com.example.weatherapp.domain.usecase.forecast.AddForecastToDbUseCase
import com.example.weatherapp.domain.usecase.forecast.GetForecastFromDbUseCase
import com.example.weatherapp.domain.usecase.forecast.GetForecastUseCase
import com.example.weatherapp.domain.usecase.forecast.UpdateCityDbUseCase
import com.example.weatherapp.domain.usecase.forecast.UpdateForecastDbUseCase
import com.example.weatherapp.domain.usecase.location.GetLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val addForecastDb: AddForecastToDbUseCase,
    private val addCityDb: AddCityToDbUseCase,
    private val updateCityDbUseCase: UpdateCityDbUseCase,
    private val getForecastDb: GetForecastFromDbUseCase,
    private val updateForecastDb: UpdateForecastDbUseCase,
    private val getForecast: GetForecastUseCase,
    private val getCurrentLocation: GetLocationUseCase
) : ViewModel() {

    private val _homeForecastState = MutableStateFlow<HomeForecastState>(HomeForecastState.Loading)
    val homeForecastState = _homeForecastState.asStateFlow()

    fun loadLocation() {
        _homeForecastState.value = HomeForecastState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val locationData = getCurrentLocation.getLocation()
                if (locationData != null) {
                    fetchForecast(locationData.latitude, locationData.longitude)
                } else if (isForecastCached()) {
                    getCachedForecast()
                } else {
                    _homeForecastState.value = HomeForecastState.Error(ExceptionTitles.NO_INTERNET_CONNECTION)
                }
            } catch (e: Exception) {
                if (isForecastCached()) {
                    getCachedForecast()
                } else {
                    _homeForecastState.value = HomeForecastState.Error(e.message)
                }
            }
        }
    }

    private suspend fun fetchForecast(latitude: Double, longitude: Double) {
        when (val result = getForecast.getForecast(latitude, longitude)) {
            is Resource.Success -> {
                _homeForecastState.value = HomeForecastState.Success(result.data)
                if (result.data != null) {
                    if (!isForecastCached()) {
                        cacheForecast(result.data, result.data.cityDtoData)
                    } else {
                        updateCachedForecast(result.data, result.data.cityDtoData)
                    }
                }
            }
            is Resource.Error -> {
                _homeForecastState.value = HomeForecastState.Error(result.message)
            }
        }
    }

    private suspend fun cacheForecast(forecast: Forecast, city: City) {
        addForecastDb.addForecastToDbUseCase(
            forecast,
            forecast.weatherList.size
        )
        addCityDb.addCityDb(city)
    }

    private suspend fun updateCachedForecast(forecast: Forecast, city: City) {
        updateForecastDb.updateForecastDbUseCase(
            forecast,
            forecast.weatherList.size
        )
        updateCityDbUseCase.updateCityDb(city)
    }

    // Data cannot be null.
    // Because before this function is called, it is checked for null with the isForecastCached() function.
    private fun getCachedForecast() {
        _homeForecastState.value =
            HomeForecastState.Success(getForecastDb.getForecastFromDbUseCase())
    }

    private fun isForecastCached(): Boolean {
        return getForecastDb.getForecastFromDbUseCase() != null
    }
}