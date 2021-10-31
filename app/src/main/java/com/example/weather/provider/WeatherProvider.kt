package com.example.weather.provider

import com.example.weather.model.WeatherResponse
import com.example.weather.service.WeatherService
import io.reactivex.Single

class WeatherProvider(val weatherService: WeatherService) {
 fun getDetails() : Single<WeatherResponse> {
    return  weatherService.getWeatherResponse()
}
}