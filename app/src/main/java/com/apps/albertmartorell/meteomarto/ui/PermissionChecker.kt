package com.apps.albertmartorell.meteomarto.ui

import android.app.Activity
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.single.BasePermissionListener
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 *
 * Entity that allow us checking if a permission is granted
 */
class PermissionChecker(private val activity: Activity, private val permission: String) {

    // I create a suspend fun in order to be called from a coroutine

    // Potser hi ha llibreries que només tenen funcions async amb callbacks, i no tenen
    // la seva equivlència sync. Per poder utilitzar aquestes llibreries amb corrutines,
    // utilitzem les funcions suspendCancellableCoroutine o suspendCoroutine, les quals ens
    // permeten convertir una funció des del món dels callbacks al món de les coroutines.

    // suspendCancellableCoroutine ens retorna un objecte Continuation que ens serveix
    // per utilitzar el resultat del callback, i retornar-lo com a resultat de la funció
    suspend fun request(): Boolean =

        suspendCancellableCoroutine { continuation ->
            Dexter
                .withActivity(activity)
                .withPermission(permission)
                .withListener(object : BasePermissionListener() {

                    override fun onPermissionGranted(response: PermissionGrantedResponse?) {

                        // To resume() is passed the value to return
                        continuation.resume(true)

                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse?) {

                        // To resume() is passed the value to return
                        continuation.resume(false)

                    }

                }).check()
        }

}