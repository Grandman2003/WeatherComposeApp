package com.example.weather_feature_api.domain.models

import java.time.LocalDateTime

data class WeatherData (
        val time: LocalDateTime,
        val temperatureCelsius: Double,
        val pressureLevel: Double,
        val windSpeed: Double,
        val humidity: Double,
        val weatherTypeBase: WeatherTypeBase
        )