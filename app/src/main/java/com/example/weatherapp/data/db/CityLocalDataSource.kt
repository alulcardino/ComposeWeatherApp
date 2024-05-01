package com.example.weatherapp.data.db

import com.example.weatherapp.data.db.entity.CityEntity
import com.example.weatherapp.data.db.room.CityDao
import javax.inject.Inject

class CityLocalDataSource @Inject constructor(private val cityDao: CityDao) {

    suspend fun addCity(cityEntity: CityEntity) =
        cityDao.addCity(cityEntity)

    fun getCity() = cityDao.getCity()

    suspend fun updateCity(cityEntity: CityEntity) =
        cityDao.updateCity(cityEntity)
}