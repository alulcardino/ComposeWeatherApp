package com.example.weatherapp.domain.usecase.forecast

import com.example.weatherapp.core.Resource
import com.example.weatherapp.data.repository.ForecastRepositoryImpl
import com.example.weatherapp.domain.model.Forecast
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(private val forecastRepositoryImpl: ForecastRepositoryImpl) {
    suspend fun getForecast(latitude: Double, longitude: Double): Resource<Forecast> =
        forecastRepositoryImpl.getForecastData(latitude, longitude)
}