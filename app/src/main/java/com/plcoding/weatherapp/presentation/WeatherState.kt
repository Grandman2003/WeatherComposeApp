package com.plcoding.weatherapp.presentation

import com.example.weather_feature_api.domain.models.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
