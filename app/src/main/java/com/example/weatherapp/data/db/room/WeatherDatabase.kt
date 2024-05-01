package com.example.weatherapp.data.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapp.data.db.entity.CityEntity
import com.example.weatherapp.data.db.entity.ForecastEntity
import com.example.weatherapp.data.db.entity.MyCityEntity

@Database(entities = [CityEntity::class, ForecastEntity::class, MyCityEntity::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao

    abstract fun forecastWeatherDao(): ForecastDao

    abstract fun myCityDao(): MyCityDao
}