package com.example.weatherapp.data.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.weatherapp.data.db.entity.MyCityEntity

const val my_city_table = "my_city"

@Dao
interface MyCityDao {
    @Insert
    suspend fun addCity(myCityEntity: MyCityEntity)

    @Query("SELECT * FROM $my_city_table")
    fun getMyCity(): List<MyCityEntity>

    @Query("DELETE FROM $my_city_table WHERE city = :cityName")
    fun deleteMyCity(cityName: String)

    @Query("UPDATE $my_city_table SET `temp` = :temp, latitude = :latitude, longitude = :longitude, description = :description, weather_image = :weatherImage WHERE city = :cityName")
    suspend fun updateMyCity(
        temp: Double,
        latitude: Double,
        longitude: Double,
        cityName: String,
        description: String,
        weatherImage: Int
    )

    @Query("SELECT * FROM $my_city_table WHERE city = :cityName")
    suspend fun getSpecificCity(cityName: String) : MyCityEntity?
}