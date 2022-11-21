package com.example.weather_feature_impl.di.providers

import com.example.weather_feature_api.domain.usecases.CurrentLocationUseCase
import com.example.weather_feature_api.domain.usecases.WeatherDataUseCase
import com.example.weather_feature_api.domain.usecases.WeatherUseCases
import com.example.weather_feature_impl.data.remote.WeatherApi
import com.example.weather_feature_impl.di.PerFeature
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Inject
import javax.inject.Provider

@Module
class WeatherProvider() {
    @Provides
    @PerFeature
    fun provideWeatherApi(): WeatherApi =
        Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
}