package com.apps.albertmartorell.meteomarto.ui

import android.location.Geocoder
import android.location.Location

/*
 From a Location it returns a region. Else returns a default region
 */
fun Location?.toRegion(geoCoder: Geocoder, defaultRegion: String): String {

    val addresses = this?.let {

        geoCoder.getFromLocation(latitude, longitude, 1)

    }

    return addresses?.firstOrNull()?.countryCode ?: defaultRegion

}

// todo inflate layout, toast.....