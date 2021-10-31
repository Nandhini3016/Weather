package com.example.weather.adaptor

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.ItemCardViewBinding
import com.example.weather.viewmodel.ItemCardViewModel

class WeatherViewHolder(val binding: ItemCardViewBinding) :
    RecyclerView.ViewHolder(binding.root){
    fun bind(itemCardViewModel: ItemCardViewModel) {
        binding.itemViewModel = itemCardViewModel
        binding.executePendingBindings()
    }
}