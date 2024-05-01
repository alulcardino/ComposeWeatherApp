package com.example.weatherapp.domain.usecase.my_city

import com.example.weatherapp.data.repository.MyCityRepositoryImpl
import javax.inject.Inject

class GetMyCityUseCase @Inject constructor(private val myCityRepositoryImpl: MyCityRepositoryImpl) {
    fun getMyCity() = myCityRepositoryImpl.getMyCity()
}