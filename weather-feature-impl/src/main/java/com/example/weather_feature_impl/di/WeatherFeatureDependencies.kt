package com.example.weather_feature_impl.di

import android.app.Application
import com.example.module_injector.FeatureDependencies

interface WeatherFeatureDependencies: FeatureDependencies {
    val application: Application
}