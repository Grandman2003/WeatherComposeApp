package com.example.weather_feature_impl.di.component

import com.example.module_injector.ComponentHolder
import com.example.weather_feature_api.di.WeatherFeatureAPI
import com.example.weather_feature_impl.di.WeatherFeatureDependencies

object WeatherFeatureComponentHolder: ComponentHolder<WeatherFeatureAPI, WeatherFeatureDependencies> {
    private  var weatherComponent: WeatherFeatureComponent? = null

    override fun init(dependencies: WeatherFeatureDependencies) {
        if(weatherComponent ==null){
            synchronized(WeatherFeatureComponentHolder::class){
                if(weatherComponent ==null){
                    weatherComponent = WeatherFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): WeatherFeatureAPI {
        checkNotNull(weatherComponent){"The weather component is not initialized"}
        return weatherComponent!!
    }

    override fun reset() {
        weatherComponent = null
    }
}