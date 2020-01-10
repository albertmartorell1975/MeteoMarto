package com.apps.albertmartorell.meteomarto.ui

import android.app.Activity
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.single.BasePermissionListener

/**
 * This entity ask for an specific permission
 */
class PermissionRequester(private val activity: Activity, private val permission: String) {

//    /**
//     * Aquí tenim un lambda:
//     *
//     * L'operació anomenada continuation, té un valor d'entrada Boolean, i de sortida no retorna res.
//     * Les funcions en Kotlin funcionen com un tipus, en aquí tenim que continuation és del tipus (Boolean) i la fletxa per indicar el valor de sortida.
//     */
//    fun request(continuation: (value: Boolean) -> Unit) {
//
//        // en aquí tenim la implementació de la lambda
//        Dexter
//            .withActivity(activity)
//            .withPermission(permission)
//            .withListener(object : BasePermissionListener() {
//
//                override fun onPermissionGranted(response: PermissionGrantedResponse?) {
//
//                    // To resume() is passed the value to return
//                    continuation(true)
//
//                }
//
//                override fun onPermissionDenied(response: PermissionDeniedResponse?) {
//
//                    // To resume() is passed the value to return
//                    continuation(false)
//
//                }
//
//                // al ser la última línia és el valor de retorn de la lambda (en aquest cas Unit o void)
//            }).check()
//
//    }


    fun request(): Boolean {

        var result = false
        Dexter
            .withActivity(activity)
            .withPermission(permission)
            .withListener(object : BasePermissionListener() {

                override fun onPermissionGranted(response: PermissionGrantedResponse?) {

                    result = true

                }

                override fun onPermissionDenied(response: PermissionDeniedResponse?) {

                    result = false

                }

            }).check()

        return result

    }

}