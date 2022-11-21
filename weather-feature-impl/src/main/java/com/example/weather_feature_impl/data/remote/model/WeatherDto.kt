package com.example.weather_feature_impl.data.remote.model

import com.squareup.moshi.Json

data class WeatherDto (
    @field: Json(name = "hourly")
    val weatherData: WeatherDataDto
    )