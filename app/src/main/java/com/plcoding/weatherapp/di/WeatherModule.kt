package com.plcoding.weatherapp.di

import android.app.Application
import com.example.weather_feature_api.di.WeatherFeatureAPI
import com.example.weather_feature_api.domain.usecases.WeatherUseCases
import com.example.weather_feature_impl.di.component.WeatherFeatureComponentHolder
import com.example.weather_feature_impl.di.WeatherFeatureDependencies
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class WeatherModule {

    @Provides
    @Singleton
    fun getWeatherDependencies(
        application: Application
    ) = object : WeatherFeatureDependencies{
        override val application: Application = application
    }

    @Provides
    @Singleton
    @Inject
    fun getWeatherFeatureApi(dependencies: WeatherFeatureDependencies):WeatherFeatureAPI{
        WeatherFeatureComponentHolder.init(dependencies)
        return WeatherFeatureComponentHolder.get()
    }

    @Provides
    @Singleton
    @Inject
    fun getWeatherUseCases(weatherApi: WeatherFeatureAPI): WeatherUseCases = weatherApi.getWeatherUseCases()
}