package com.example.weather_feature_impl.di.providers

import android.app.Application
import com.example.weather_feature_impl.di.PerFeature
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class LocationProvider {
    @Provides
    @Inject
    @PerFeature
    fun providesFusionLocationProviderClient(app: Application): FusedLocationProviderClient
            = LocationServices.getFusedLocationProviderClient(app)
}