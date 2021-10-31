package com.example.weather.model

data class WeatherResponse(val data: List<WeatherTimelyResponse>)

data class WeatherTimelyResponse(val temp : Int, val time : Int, val rain: Int, val wind : Int)