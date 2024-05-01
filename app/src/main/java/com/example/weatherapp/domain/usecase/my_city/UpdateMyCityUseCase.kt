package com.example.weatherapp.domain.usecase.my_city

import com.example.weatherapp.data.repository.MyCityRepositoryImpl
import com.example.weatherapp.domain.model.MyCity
import javax.inject.Inject

class UpdateMyCityUseCase @Inject constructor(private val myCityRepositoryImpl: MyCityRepositoryImpl) {
    suspend fun updateMyCityUseCase(myCity: MyCity) = myCityRepositoryImpl.updateMyCity(myCity)
}