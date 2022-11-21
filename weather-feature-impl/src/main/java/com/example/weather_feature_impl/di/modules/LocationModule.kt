package com.example.weather_feature_impl.di.modules

import android.app.Application
import com.example.weather_feature_api.domain.usecases.CurrentLocationUseCase
import com.example.weather_feature_impl.data.repositories.location.LocationTracker
import com.example.weather_feature_impl.data.repositories.location.LocationTrackerImpl
import com.example.weather_feature_impl.di.providers.LocationProvider
import com.example.weather_feature_impl.domain.usecases.CurrentLocationUseCaseImpl
import com.google.android.gms.location.LocationServices
import dagger.Binds
import dagger.Module

@Module(includes = [LocationProvider::class])
internal interface LocationModule {
   @Binds
   fun LocationTrackerImpl.provideLocationTracker(): LocationTracker

   @Binds
   fun CurrentLocationUseCaseImpl.provideCurrentLocationUseCase(): CurrentLocationUseCase
}