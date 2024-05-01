package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.db.entity.CityEntity
import com.example.weatherapp.domain.mapper.IEntityMapper
import com.example.weatherapp.domain.model.City
import com.example.weatherapp.domain.model.Coord
import javax.inject.Inject

class CityEntityMapper @Inject constructor() : IEntityMapper<CityEntity, City> {
    override fun mapFromEntity(entity: CityEntity): City {
        return City(
            entity.country,
            entity.timezone,
            entity.sunrise,
            entity.sunset,
            entity.cityName,
            Coord(
                entity.latitude,
                entity.longitude
            )
        )
    }

    override fun entityFromModel(model: City): CityEntity {
        return CityEntity(
            id = 1,
            country = model.country,
            timezone = model.timezone,
            sunrise = model.sunrise,
            sunset = model.sunset,
            cityName = model.cityName,
            latitude = model.coordinate.latitude,
            longitude = model.coordinate.longitude
        )
    }
}