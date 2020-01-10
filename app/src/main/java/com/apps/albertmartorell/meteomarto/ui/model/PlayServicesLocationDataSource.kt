package com.apps.albertmartorell.meteomarto.ui.model

import android.app.Application
import android.location.Location
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * Entity that decouples RegionRepository from Google's LocationServices.
 * It returns the current location
 */

interface LocationDataSource {

    suspend fun findLastLocation(): Location?

}

class PlayServicesLocationDataSource(application: Application) : LocationDataSource {

    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(application)

    /**
     * It collects the last localization, once finished it returns the location as a result of the suspend function
     */
    override suspend fun findLastLocation(): Location? =

    // Potser hi ha llibreries que només tenen funcions async amb callbacks, i no tenen
    // la seva equivlència sync. Per poder utilitzar aquestes llibreries amb corrutines,
    // utilitzem les funcions suspendCancellableCoroutine o suspendCoroutine, les quals ens
    // permeten convertir una funció des del món dels callbacks al món de les coroutines.
        // La funció suspendCancellableCoroutine ens retorna un objecte Continuation que ens serveix  per utilitzar el resultat del callback, i retornar-lo com a resultat de la funció

        suspendCancellableCoroutine { continuation ->
            fusedLocationClient.lastLocation.addOnCompleteListener {

                continuation.resume(it.result)

            }

        }

}