package com.apps.albertmartorell.meteomarto.ui

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.widget.ImageView
import com.apps.albertmartorell.meteomarto.MeteoMartoApp
import com.apps.albertmartorell.meteomarto.framework.server.RetrofitBuilder
import com.bumptech.glide.Glide

/*
 From a Location it returns a region. Else returns a default region
 */
fun Location?.toRegion(geoCoder: Geocoder, defaultRegion: String = ""): String {

    val addresses = this?.let {

        geoCoder.getFromLocation(latitude, longitude, 1)

    }

    // If null, then location should be read from local database
    return addresses?.firstOrNull()?.countryCode ?: ""

}

val Context.app: MeteoMartoApp
    get() = applicationContext as MeteoMartoApp


fun ImageView.loadIconsWeather(url: String?) {

    url?.let {
        Glide.with(this)
            .load(RetrofitBuilder.iconsPrefixWeatherUrl + url + RetrofitBuilder.iconsSuffixWeatherUrl)
            .into(this)
    }

}

// todo inflate layout, toast.....