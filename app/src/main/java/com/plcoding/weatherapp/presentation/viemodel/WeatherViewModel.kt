package com.plcoding.weatherapp.presentation.viemodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_feature_api.domain.usecases.WeatherUseCases
import com.example.weather_feature_api.domain.util.Resource
import com.plcoding.weatherapp.presentation.WeatherState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class WeatherViewModel @AssistedInject constructor(
    @Assisted private val weatherUseCases: WeatherUseCases
): ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherLoad(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            weatherUseCases.currentLocation.invoke()?.let {location ->
                when(val result = weatherUseCases.weatherDataUseCase.invoke(
                    location.latitude, location.longitude
                )){
                    is Resource.Success ->{
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Could not retrieve location. Make sure to grant permission and enable GPS"
                )
            }
        }
    }

    @AssistedFactory
    interface Factory{
        fun create(
            weatherUseCases: WeatherUseCases
        ): WeatherViewModel
    }
}