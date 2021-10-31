package com.example.weather.viewmodel

import androidx.lifecycle.*
import com.example.weather.model.WeatherResponse
import com.example.weather.provider.WeatherProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.StringBuilder
import java.time.Instant
import java.time.ZoneId
import kotlin.collections.ArrayList


class HomeViewModel(val weatherProvider: WeatherProvider) : ViewModel(), LifecycleObserver {

    val itemCardViewModelList : kotlin.collections.ArrayList<ItemCardViewModel> = arrayListOf()
    val itemCardViewModelListLiveData : MutableLiveData<ArrayList<ItemCardViewModel>> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate()
    {
        /*viewModelScope.launch {
               val weatherResponse = weatherProvider.getDetails()
                updateValues(weatherResponse)
        }*/

        val observeOn = weatherProvider.getDetails().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this :: onSucccess, this:: onError)

    }

    private fun onSucccess(weatherResponse: WeatherResponse) {
        for (i in weatherResponse.data.indices)
        {
            val weatherTimelyResponse = weatherResponse.data[i]
            val cel = weatherTimelyResponse.temp.toString()
            val rain = weatherTimelyResponse.rain.toString()
            val wind = weatherTimelyResponse.wind.toString()

            val date = Instant.ofEpochMilli(weatherTimelyResponse.time.toLong()).atZone(ZoneId.systemDefault()).toLocalDate()
            var dateValue = StringBuilder()
            dateValue = dateValue.append(date.month.name).append(" ").append(date.dayOfMonth).append(" ").append(date.year)
            itemCardViewModelList.add(ItemCardViewModel("$cel°C",dateValue.toString(), "$rain%",
                "$wind km/hr"))
        }
        itemCardViewModelListLiveData.postValue(itemCardViewModelList)
    }

    fun onError(t : Throwable)
    {
        print(">>"+t.message)
    }
}