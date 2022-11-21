package com.example.weather_feature_impl.domain.usecases

import com.example.weather_feature_api.domain.usecases.CurrentLocationUseCase
import com.example.weather_feature_api.domain.usecases.WeatherDataUseCase
import com.example.weather_feature_api.domain.usecases.WeatherUseCases
import javax.inject.Inject

data class WeatherUseCasesImpl @Inject constructor(
    override val currentLocation: CurrentLocationUseCase,
    override val weatherDataUseCase: WeatherDataUseCase
): WeatherUseCases