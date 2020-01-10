package com.apps.albertmartorell.meteomarto.ui.model

import android.Manifest
import android.app.Application
import android.location.Geocoder
import android.location.Location
import com.apps.albertmartorell.meteomarto.ui.toRegion

/**
 * Entity that returns the current region (country)
 */
class RegionRepository(application: Application) {

    companion object {

        private val DEFAULT_REGION = "US"

    }

    // to get the current user location. To avoid to be coupled to Google's LocationServices, RegionRepository depends on LocationDataSource which is an interface
    private var locationDataSource: LocationDataSource = PlayServicesLocationDataSource(application)
    // it checks if the user permission is granted
    private val coarsePermissionChecker =
        PermissionChecker(application, Manifest.permission.ACCESS_COARSE_LOCATION)


    suspend fun findLastRegion(): String = findLastLocation().toRegion(geoCoder, DEFAULT_REGION)

    // to get a direction from location to find out the country
    private var geoCoder = Geocoder(application)

    private suspend fun findLastLocation(): Location? {

        val success = coarsePermissionChecker.check()
        return if (success) locationDataSource.findLastLocation() else null

    }

}