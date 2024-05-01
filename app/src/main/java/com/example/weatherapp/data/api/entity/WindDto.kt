package com.example.weatherapp.data.api.entity

import com.google.gson.annotations.SerializedName

data class WindDto(
    @SerializedName("speed") val speed: Double,
)
