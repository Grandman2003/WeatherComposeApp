package com.example.weather_feature_impl.domain.usecases

import android.location.Location
import com.example.weather_feature_api.domain.usecases.CurrentLocationUseCase
import com.example.weather_feature_impl.data.repositories.location.LocationTracker
import javax.inject.Inject
import javax.inject.Provider

class CurrentLocationUseCaseImpl @Inject constructor(
    private val locationTracker: Provider<LocationTracker>
): CurrentLocationUseCase {
    override suspend operator fun invoke(): Location?
        = locationTracker.get().getCurrentLocation()
}