package com.example.weather_feature_impl.domain.usecases

import com.example.weather_feature_api.domain.models.WeatherData
import com.example.weather_feature_api.domain.models.WeatherInfo
import com.example.weather_feature_api.domain.usecases.WeatherDataUseCase
import com.example.weather_feature_api.domain.util.Resource
import com.example.weather_feature_impl.data.repositories.weather.WeatherRepository
import javax.inject.Inject
import javax.inject.Provider

class WeatherDataUseCaseImpl @Inject constructor(
    private val weatherRepository: Provider<WeatherRepository>
): WeatherDataUseCase {
    override suspend operator fun invoke(lat: Double, long: Double): Resource<WeatherInfo>
        = weatherRepository.get().getWeatherData(lat, long)
}