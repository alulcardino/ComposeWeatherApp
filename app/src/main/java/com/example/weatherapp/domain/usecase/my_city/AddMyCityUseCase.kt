package com.example.weatherapp.domain.usecase.my_city

import com.example.weatherapp.data.repository.MyCityRepositoryImpl
import com.example.weatherapp.domain.model.MyCity
import javax.inject.Inject

class AddMyCityUseCase @Inject constructor(private val myCityRepositoryImpl: MyCityRepositoryImpl) {
    suspend fun addMyCity(myCity: MyCity) = myCityRepositoryImpl.addMyCity(myCity)
}