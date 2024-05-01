package com.example.weatherapp.domain.usecase.forecast

import com.example.weatherapp.data.repository.ForecastRepositoryImpl
import com.example.weatherapp.domain.model.Forecast
import javax.inject.Inject

class GetForecastFromDbUseCase @Inject constructor(private val forecastRepositoryImpl: ForecastRepositoryImpl) {
    fun getForecastFromDbUseCase() : Forecast? = forecastRepositoryImpl.getForecastWeather()
}