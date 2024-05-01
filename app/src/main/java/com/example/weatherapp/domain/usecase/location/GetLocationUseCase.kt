package com.example.weatherapp.domain.usecase.location

import com.example.weatherapp.data.location.DefaultLocationTracker
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(private val defaultLocationTracker: DefaultLocationTracker) {
    suspend fun getLocation() = defaultLocationTracker.getCurrentLocation()
}