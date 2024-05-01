package com.example.weatherapp.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_data")
data class CityEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "country")
    var country: String,

    @ColumnInfo(name = "timezone")
    var timezone: Int,

    @ColumnInfo(name = "sunrise")
    var sunrise: Long,

    @ColumnInfo(name = "sunset")
    var sunset: Long,

    @ColumnInfo(name = "city_name")
    var cityName: String,

    @ColumnInfo(name = "latitude")
    var latitude: Double,

    @ColumnInfo(name = "longitude")
    var longitude: Double
)
