package com.example.weather

import androidx.lifecycle.ViewModelProvider
import com.example.weather.provider.WeatherProvider
import com.example.weather.service.WeatherService

object Injection {
    fun provideNasaInfoRepository() : WeatherProvider {
        return WeatherProvider(WeatherService.create())
    }
    fun viewModelFactory() : ViewModelProvider.Factory {
        return ViewModelFactory(provideNasaInfoRepository())
    }
}