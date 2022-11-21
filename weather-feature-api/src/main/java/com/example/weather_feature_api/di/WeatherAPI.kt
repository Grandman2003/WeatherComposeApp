package com.example.weather_feature_api.di

import com.example.module_injector.FeatureApi
import com.example.weather_feature_api.domain.usecases.WeatherUseCases

interface WeatherFeatureAPI: FeatureApi {
    fun getWeatherUseCases(): WeatherUseCases
}