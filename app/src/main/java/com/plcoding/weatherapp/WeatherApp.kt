package com.plcoding.weatherapp

import android.app.Application
import com.plcoding.weatherapp.di.AppComponent
import com.plcoding.weatherapp.di.DaggerAppComponent

class WeatherApp: Application() {
    override fun onCreate() {
        super.onCreate()
        AppComponent.init(
            DaggerAppComponent
                .builder()
                .application(this)
                .build()
        )
    }
}