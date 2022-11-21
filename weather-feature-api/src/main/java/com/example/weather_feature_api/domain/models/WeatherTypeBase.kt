package com.example.weather_feature_api.domain.models

import androidx.annotation.DrawableRes

abstract class WeatherTypeBase (
    val weatherDescription: String,
    @DrawableRes val iconResource: Int
    )