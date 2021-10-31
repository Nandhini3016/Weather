package com.example.weather


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weather.provider.WeatherProvider
import com.example.weather.viewmodel.HomeViewModel

class ViewModelFactory(private val weatherProvider: WeatherProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java))
            return HomeViewModel(weatherProvider) as T
        else
            throw IllegalAccessException("unKnown class")
    }
}