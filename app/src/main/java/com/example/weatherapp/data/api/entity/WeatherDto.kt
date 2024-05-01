package com.example.weatherapp.data.api.entity

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("main") val mainDescription: String,
    @SerializedName("description") val description: String
)
