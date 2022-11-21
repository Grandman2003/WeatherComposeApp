package com.example.weather_feature_api.domain.usecases

import android.location.Location

interface CurrentLocationUseCase {
    suspend operator fun invoke(): Location?
}