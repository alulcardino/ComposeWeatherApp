package com.example.weatherapp.domain.repository

import com.example.weatherapp.core.Resource
import com.example.weatherapp.domain.model.City
import com.example.weatherapp.domain.model.Forecast

interface ForecastRepository {
    suspend fun getForecastData(latitude: Double, longitude: Double, ): Resource<Forecast>

    suspend fun getForecastDataWithCityName(cityName: String): Resource<Forecast>

    suspend fun addForecastWeather(forecast: Forecast)

    suspend fun addCity(city: City)

    fun getForecastWeather() : Forecast?

    fun getCity() : City

    suspend fun updateForecastWeather(forecast: Forecast)

    suspend fun updateCity(city: City)
}