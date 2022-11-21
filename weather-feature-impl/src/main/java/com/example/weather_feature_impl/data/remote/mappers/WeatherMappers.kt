package com.example.weather_feature_impl.data.remote.mappers

import com.example.weather_feature_api.domain.models.WeatherData
import com.example.weather_feature_api.domain.models.WeatherInfo
import com.example.weather_feature_impl.data.remote.model.WeatherDataDto
import com.example.weather_feature_impl.data.remote.model.WeatherDto
import com.example.weather_feature_impl.domain.model.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData (
    val index : Int,
    val data: WeatherData
)


fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>>
    = time.mapIndexed { index, time ->
    val temperature = temperatures[index]
    val weatherCode = weatherCodes[index]
    val windSpeed = windSpeeds[index]
    val pressure = pressures[index]
    val humidity = humidities[index]
    IndexedWeatherData(
        index = index,
        data =  WeatherData(
            time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
            temperatureCelsius = temperature,
            pressureLevel = pressure,
            windSpeed = windSpeed,
            humidity = humidity,
            weatherTypeBase = WeatherType.fromWMO(weatherCode)
        )
    )
}.groupBy {
    it.index / 24
}.mapValues {
    it.value.map { it.data }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo{
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else if (now.hour + 1 == 24) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}