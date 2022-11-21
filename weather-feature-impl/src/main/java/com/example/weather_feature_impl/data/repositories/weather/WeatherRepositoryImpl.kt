package com.example.weather_feature_impl.data.repositories.weather

import com.example.weather_feature_api.domain.models.WeatherInfo
import com.example.weather_feature_api.domain.util.Resource
import com.example.weather_feature_impl.data.remote.WeatherApi
import com.example.weather_feature_impl.data.remote.mappers.toWeatherInfo
import com.example.weather_feature_impl.data.repositories.weather.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}