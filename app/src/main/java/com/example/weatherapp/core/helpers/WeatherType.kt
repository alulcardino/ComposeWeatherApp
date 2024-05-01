package com.example.weatherapp.core.helpers

import androidx.annotation.DrawableRes
import com.example.weatherapp.R

sealed class WeatherType(
    val weatherDescription: String,
    @DrawableRes val id: Int
) {
    object ClearSkyDay : WeatherType(
        weatherDescription = WeatherConditions.CLEAR_SKY,
        id = R.drawable.clear_day
    )

    object ClearSkyNight : WeatherType(
        weatherDescription = WeatherConditions.CLEAR_SKY,
        id = R.drawable.clear_night
    )

    object FewCloudsDay : WeatherType(
        weatherDescription = WeatherConditions.FEW_CLOUDS,
        id = R.drawable.cloud_day
    )

    object FewCloudsNight : WeatherType(
        weatherDescription = WeatherConditions.FEW_CLOUDS,
        id = R.drawable.cloud_night
    )

    object ScatteredClouds : WeatherType(
        weatherDescription = WeatherConditions.SCATTERED_CLOUDS,
        id = R.drawable.cloud
    )

    object BrokenCloudsDay : WeatherType(
        weatherDescription = WeatherConditions.BROKEN_CLOUDS,
        id = R.drawable.cloud_day
    )

    object BrokenCloudsNight : WeatherType(
        weatherDescription = WeatherConditions.BROKEN_CLOUDS,
        id = R.drawable.cloud_day
    )

    object ShowerRainDay : WeatherType(
        weatherDescription = WeatherConditions.SHOWER_RAIN,
        id = R.drawable.rain_day
    )

    object ShowerRainNight : WeatherType(
        weatherDescription = WeatherConditions.SHOWER_RAIN,
        id = R.drawable.rain_night
    )

    object RainDay : WeatherType(
        weatherDescription = WeatherConditions.RAIN,
        id = R.drawable.rain_day
    )

    object RainNight : WeatherType(
        weatherDescription = WeatherConditions.RAIN,
        id = R.drawable.rain_day
    )

    object Thunderstorm : WeatherType(
        weatherDescription = WeatherConditions.THUNDERSTORM,
        id = R.drawable.thunderstorm
    )

    object Snow : WeatherType(
        weatherDescription = WeatherConditions.SNOW,
        id = R.drawable.snow
    )

    object MistDay : WeatherType(
        weatherDescription = WeatherConditions.MIST,
        id = R.drawable.mist
    )

    object MistNight : WeatherType(
        weatherDescription = WeatherConditions.MIST,
        id = R.drawable.mist
    )

    companion object {
        fun setWeatherType(
            mainDescription: String,
            weatherDescription: String,
            hour: String
        ): Int {
            when (mainDescription) {
                MainWeatherConditions.CLOUDS -> {
                    return if (weatherDescription == ScatteredClouds.weatherDescription) {
                        ScatteredClouds.id
                    } else if (weatherDescription == FewCloudsDay.weatherDescription) {
                        if (checkTime(hour)) {
                            FewCloudsNight.id
                        } else {
                            FewCloudsDay.id
                        }
                    } else {
                        if (checkTime(hour)) {
                            BrokenCloudsNight.id
                        } else {
                            BrokenCloudsDay.id
                        }
                    }
                }
                MainWeatherConditions.RAIN -> {
                    return if (weatherDescription == ShowerRainDay.weatherDescription) {
                        if (checkTime(hour)) {
                            ShowerRainNight.id
                        } else {
                            ShowerRainDay.id
                        }
                    } else {
                        if (checkTime(hour)) {
                            RainNight.id
                        } else {
                            RainDay.id
                        }
                    }
                }
                MainWeatherConditions.THUNDERSTORM -> {
                    return Thunderstorm.id
                }
                MainWeatherConditions.SNOW -> {
                    return Snow.id
                }
                MainWeatherConditions.CLEAR -> {
                    return if (checkTime(hour)) {
                        ClearSkyNight.id
                    } else {
                        ClearSkyDay.id
                    }
                }
                else -> {
                    return if (checkTime(hour)) {
                        MistNight.id
                    } else {
                        MistDay.id
                    }
                }
            }
        }

        // false -> day
        // true -> night
        private fun checkTime(hour: String): Boolean {
            return if ((hour.substring(0, 2) == "00" || hour.substring(0, 2) == "03" || hour.substring(0, 2) == "06") && hour.substring(3, 5) == "AM") {
                true
            } else if (hour.substring(0, 2) == "12" && hour.substring(3, 5) == "AM") {
                true
            } else (hour.substring(0, 2) == "09") && hour.substring(3, 5) == "PM"
        }
    }
}
