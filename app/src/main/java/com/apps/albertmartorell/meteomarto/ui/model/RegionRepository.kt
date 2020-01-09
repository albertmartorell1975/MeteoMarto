package com.apps.albertmartorell.meteomarto.ui.model

import android.Manifest
import android.app.Activity
import android.location.Geocoder
import android.location.Location
import com.apps.albertmartorell.meteomarto.ui.toRegion

/**
 * Entity that returns the current region (country)
 */
class RegionRepository(activity: Activity) {

    companion object {

        private val DEFAULT_REGION = "US"

    }

    suspend fun findLastRegion(): String = findLastLocation().toRegion(
        geoCoder,
        DEFAULT_REGION
    )

    // to get the current user location. To avoid to be coupled to Google's LocationServices, RegionRepository depends on LocationDataSource which is an interface
    private var locationDataSource: LocationDataSource = PlayServicesLocationDataSource(activity)
    // it checks if the user permission is granted
    private val coarsePermissionChecker =
        PermissionChecker(
            activity,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    // to get a direction from location to find out the country
    private var geoCoder = Geocoder(activity)

    private suspend fun findLastLocation(): Location? {

        val success = coarsePermissionChecker.request()
        return if (success) locationDataSource.findLastLocation() else null

    }

}