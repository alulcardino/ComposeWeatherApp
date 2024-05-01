package com.example.weatherapp.data.api.weatherapi

import com.example.weatherapp.data.api.entity.ForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/data/2.5/forecast")
    suspend fun getForecastData(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("APPID") apiKey: String = "b26b1894f39b7044d74e09ab0ddf0fb1",
        @Query("units") units: String = "metric",
    ): ForecastDto

    @GET("/data/2.5/forecast")
    suspend fun getForecastDataWithCityName(
        @Query("q") cityName: String,
        @Query("APPID") apiKey: String = "b26b1894f39b7044d74e09ab0ddf0fb1",
        @Query("units") units: String = "metric",
    ): ForecastDto
}