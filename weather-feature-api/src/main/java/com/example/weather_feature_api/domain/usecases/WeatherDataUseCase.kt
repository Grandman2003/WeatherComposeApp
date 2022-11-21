package com.example.weather_feature_api.domain.usecases

import com.example.weather_feature_api.domain.models.WeatherData
import com.example.weather_feature_api.domain.models.WeatherInfo
import com.example.weather_feature_api.domain.util.Resource

interface WeatherDataUseCase {
    suspend operator fun invoke(lat: Double, long: Double): Resource<WeatherInfo>
}