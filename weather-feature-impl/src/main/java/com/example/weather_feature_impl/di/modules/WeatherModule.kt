package com.example.weather_feature_impl.di.modules

import com.example.weather_feature_api.domain.usecases.WeatherDataUseCase
import com.example.weather_feature_api.domain.usecases.WeatherUseCases
import com.example.weather_feature_impl.data.remote.WeatherApi
import com.example.weather_feature_impl.data.repositories.weather.WeatherRepository
import com.example.weather_feature_impl.data.repositories.weather.WeatherRepositoryImpl
import com.example.weather_feature_impl.di.PerFeature
import com.example.weather_feature_impl.di.providers.WeatherProvider
import com.example.weather_feature_impl.domain.usecases.WeatherDataUseCaseImpl
import com.example.weather_feature_impl.domain.usecases.WeatherUseCasesImpl
import dagger.Binds
import dagger.Module
import javax.inject.Inject

@Module(includes = [WeatherProvider::class])
internal interface WeatherModule {
    @Binds
    fun WeatherRepositoryImpl.provideWeatherRepository(): WeatherRepository

    @Binds
    fun WeatherDataUseCaseImpl.provideWeatherDataUseCase(): WeatherDataUseCase

    @Binds
    fun WeatherUseCasesImpl.provideUseCases(): WeatherUseCases
}