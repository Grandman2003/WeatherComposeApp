package com.plcoding.weatherapp.presentation.viemodel

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.example.weather_feature_api.domain.usecases.WeatherUseCases

class WeatherViewModelFactory<T: ViewModel>(
    private val weatherUseCases: WeatherUseCases,
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass== WeatherViewModel::class.java) return WeatherViewModel(weatherUseCases) as T
        throw error("No such viewModel")
    }
}
