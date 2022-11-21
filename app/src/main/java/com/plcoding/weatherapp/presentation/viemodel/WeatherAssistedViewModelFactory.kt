package com.plcoding.weatherapp.presentation.viemodel

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.weather_feature_api.domain.usecases.WeatherUseCases

class WeatherAssistedViewModelFactory <T: ViewModel>(
    private val weatherUseCases: WeatherUseCases,
    savedStateRegistryOwner: SavedStateRegistryOwner,
    private val create: (weatherUseCases: WeatherUseCases) -> T
): AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null){

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return create.invoke( weatherUseCases) as T
    }
}

inline fun <reified T: ViewModel> ComponentActivity.lazyViewModel(
    weatherUseCasesLazy: Lazy<WeatherUseCases>,
    noinline create: (weatherUseCases: WeatherUseCases) -> T
) = viewModels<T>  { WeatherAssistedViewModelFactory(weatherUseCasesLazy.value,this, create) }