package com.example.weatherapp.data.api.entity

import com.google.gson.annotations.SerializedName

data class CloudinessDto(
    @SerializedName("all") val cloudiness: Int
)