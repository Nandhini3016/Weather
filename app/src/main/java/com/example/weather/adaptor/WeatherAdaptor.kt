package com.example.weather.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.MainActivity
import com.example.weather.databinding.ItemCardViewBinding
import com.example.weather.viewmodel.ItemCardViewModel

class WeatherAdaptor(val arrayList: ArrayList<ItemCardViewModel>, val main : MainActivity) :  RecyclerView.Adapter<WeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = ItemCardViewBinding.inflate(inflator, parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val itemCardViewModel = arrayList.get(position)
        holder.bind(itemCardViewModel)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}
