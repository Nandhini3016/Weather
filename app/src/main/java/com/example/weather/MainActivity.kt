package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.adaptor.WeatherAdaptor
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.viewmodel.HomeViewModel
import com.example.weather.viewmodel.ItemCardViewModel

class MainActivity : AppCompatActivity(), LifecycleObserver {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val viewModel = ViewModelProvider(this, Injection.viewModelFactory()).get(HomeViewModel::class.java)
        lifecycle.addObserver(viewModel)

        viewModel.itemCardViewModelListLiveData.observe(this,
            Observer<ArrayList<ItemCardViewModel>> {
                    itemCardViewModels ->
                val adapter = WeatherAdaptor(itemCardViewModels, this@MainActivity)
                contentView.idRecyclerview.layoutManager = LinearLayoutManager(applicationContext)
                contentView.idRecyclerview.adapter = adapter
            })
    }
}