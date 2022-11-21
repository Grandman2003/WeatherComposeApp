package com.plcoding.weatherapp.di

import android.app.Application
import com.plcoding.weatherapp.presentation.MainActivity
import com.plcoding.weatherapp.presentation.viemodel.WeatherViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.internal.Preconditions
import javax.inject.Singleton

@Component(
    modules = [WeatherModule::class]
)
@Singleton
interface AppComponent {

    fun weatherViewModel(): WeatherViewModel.Factory
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder{
        fun build(): AppComponent
        @BindsInstance
        fun application(application: Application): Builder
    }

    companion object{
        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent {
            return Preconditions.checkNotNull(
                instance,
                "AppComponent is not initialized yet. Call init first."
            )!!
        }

        fun init(component: AppComponent) {
            require(instance == null) { "AppComponent is already initialized." }
            instance = component
        }
    }
}