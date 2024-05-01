package com.example.weatherapp.domain.usecase.my_city

import com.example.weatherapp.data.repository.MyCityRepositoryImpl
import javax.inject.Inject

class DeleteMyCityUseCase @Inject constructor(private val myCityRepositoryImpl: MyCityRepositoryImpl) {
    fun deleteMyCityUseCase(cityName: String) = myCityRepositoryImpl.deleteMyCity(cityName)
}