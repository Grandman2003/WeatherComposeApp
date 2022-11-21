package com.example.weather_feature_impl.di.component

import com.example.weather_feature_api.di.WeatherFeatureAPI
import com.example.weather_feature_api.domain.usecases.WeatherDataUseCase
import com.example.weather_feature_api.domain.usecases.WeatherUseCases
import com.example.weather_feature_impl.di.component.DaggerWeatherFeatureComponent
import com.example.weather_feature_impl.di.PerFeature
import com.example.weather_feature_impl.di.WeatherFeatureDependencies
import com.example.weather_feature_impl.di.modules.LocationModule
import com.example.weather_feature_impl.di.modules.WeatherModule
import dagger.Component
import javax.inject.Inject

@Component(
    dependencies = [WeatherFeatureDependencies::class],
    modules = [
        WeatherModule::class,
        LocationModule::class
    ]
)
@PerFeature
internal interface WeatherFeatureComponent: WeatherFeatureAPI  {
    @Component.Factory
    interface Factory{
        fun create(dependencies: WeatherFeatureDependencies): WeatherFeatureComponent
    }

    companion object
    {
        internal fun initAndGet(dependencies: WeatherFeatureDependencies): WeatherFeatureComponent
            = DaggerWeatherFeatureComponent.factory().create(dependencies)
    }
}