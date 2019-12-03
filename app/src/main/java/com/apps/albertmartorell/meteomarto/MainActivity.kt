package com.apps.albertmartorell.meteomarto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apps.albertmartorell.meteomarto.framework.RetrofitBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //RetrofitBuilder.cityWeatherApi.getWeather("", "", "")
RetrofitBuilder.cityWeatherByName.getWeather("")
    }

}

