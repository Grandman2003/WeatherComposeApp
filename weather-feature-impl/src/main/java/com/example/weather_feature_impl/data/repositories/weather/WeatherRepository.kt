package com.example.weather_feature_impl.data.repositories.weather

import com.example.weather_feature_api.domain.models.WeatherInfo
import com.example.weather_feature_api.domain.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}