package com.example.weatherapp.model

data class Forecast(
    val weatherList: List<ForecastWeather>,
    val cityDtoData: City
)
