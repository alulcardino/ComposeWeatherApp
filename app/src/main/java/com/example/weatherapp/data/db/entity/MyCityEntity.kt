package com.example.weatherapp.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_city")
data class MyCityEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "temp")
    var temp: Double,

    @ColumnInfo(name = "latitude")
    var latitude: Double,

    @ColumnInfo(name = "longitude")
    var longitude: Double,

    @ColumnInfo(name = "city")
    var cityName: String,

    @ColumnInfo(name = "country")
    var country: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "weather_image")
    var weatherImage: Int
)
