package com.example.weather.service
import com.example.weather.model.WeatherResponse
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherService {
    @GET("/v2/5d3a99ed2f0000bac16ec13a")
    fun getWeatherResponse() : Single<WeatherResponse>

    companion object {
        val BASE_URL = "https://www.mocky.io"

        fun create() : WeatherService {
            /* val logger = HttpLoggingInterceptor()
             logger.level = HttpLoggingInterceptor.Level.BASIC*/
            val client = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(WeatherService::class.java)
        }
    }
}