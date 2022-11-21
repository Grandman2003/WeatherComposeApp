package com.example.weather_feature_api.domain.usecases

interface WeatherUseCases {
    val currentLocation: CurrentLocationUseCase
    val weatherDataUseCase: WeatherDataUseCase
}