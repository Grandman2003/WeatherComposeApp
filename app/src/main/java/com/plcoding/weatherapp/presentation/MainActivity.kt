package com.plcoding.weatherapp.presentation

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.weather_feature_api.domain.usecases.WeatherUseCases
import com.plcoding.weatherapp.di.AppComponent
import com.plcoding.weatherapp.presentation.ui.theme.DarkBlue
import com.plcoding.weatherapp.presentation.ui.theme.DeepBlue
import com.plcoding.weatherapp.presentation.ui.theme.WeatherAppTheme
import com.plcoding.weatherapp.presentation.viemodel.WeatherViewModel
import com.plcoding.weatherapp.presentation.viemodel.WeatherViewModelFactory
import com.plcoding.weatherapp.presentation.viemodel.lazyViewModel
import com.plcoding.weatherapp.presentation.views.WeatherCard
import com.plcoding.weatherapp.presentation.views.WeatherForecast
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var weatherUseCases: WeatherUseCases

    val viewModel by lazyViewModel(lazy { weatherUseCases }){ weatherUseCases ->
        AppComponent.get().weatherViewModel().create(weatherUseCases = weatherUseCases)
    }

    /**
     * There is a second variant of viewModel Injection
     */
//     val viewModel: WeatherViewModel by lazy {
//         ViewModelProvider(
//             this, WeatherViewModelFactory<WeatherViewModel>(weatherUseCases)
//         ).get(WeatherViewModel::class.java)
//    }

    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppComponent.get().inject(this)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            viewModel.loadWeatherLoad()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))
        setContent {
            WeatherAppTheme {
                Box {
                    val scrollState = rememberScrollState()
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(DarkBlue)
                            .verticalScroll(scrollState, enabled = true),
                    ) {
                        WeatherCard(
                            state = viewModel.state,
                            backgroundColor = DeepBlue
                        )
                        Spacer(modifier =Modifier.height(16.dp))
                        WeatherForecast(state = viewModel.state)
                    }
                  if (viewModel.state.isLoading){
                      CircularProgressIndicator(
                          modifier = Modifier.align(Alignment.Center)
                      )
                  }
                    viewModel.state.error?.let {error ->
                        Text(
                            text = error,
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}