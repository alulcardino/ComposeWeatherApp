package com.example.weatherapp.core.di

import com.example.weatherapp.data.db.room.CityDao
import com.example.weatherapp.data.db.room.ForecastDao
import com.example.weatherapp.data.db.room.MyCityDao
import com.example.weatherapp.data.db.room.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun bindCurrentWeatherDao(weatherDatabase: WeatherDatabase): CityDao =
        weatherDatabase.cityDao()

    @Provides
    @Singleton
    fun bindForecastDao(weatherDatabase: WeatherDatabase): ForecastDao =
        weatherDatabase.forecastWeatherDao()

    @Provides
    @Singleton
    fun bindMyCityDao(weatherDatabase: WeatherDatabase): MyCityDao =
        weatherDatabase.myCityDao()
}