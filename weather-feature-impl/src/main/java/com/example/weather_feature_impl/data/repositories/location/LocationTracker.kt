package com.example.weather_feature_impl.data.repositories.location

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}