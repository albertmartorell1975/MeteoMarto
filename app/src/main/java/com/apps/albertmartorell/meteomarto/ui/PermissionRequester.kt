package com.apps.albertmartorell.meteomarto.ui

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.BasePermissionListener

/**
 * This entity ask for an specific permission
 */
class PermissionRequester(private val activity: Activity, private val permission: String) {

//    companion object Status {
//
//        val GRANTED: Int = 0
//        val DENIED: Int = 1
//        val DIALOG: Int = 2
//    }

//    /**
//     * Aquí tenim un lambda:
//     *
//     * L'operació anomenada continuation, té un valor d'entrada Boolean, i de sortida no retorna res.
//     * Les funcions en Kotlin funcionen com un tipus, en aquí tenim que continuation és del tipus (Boolean) i la fletxa per indicar el valor de sortida.
//     */
//    fun request(continuation: (value: Int) -> Int): Int {
//
//        var result: Int = DENIED
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
//                    //continuation(GRANTED)
//                    result = GRANTED
//                }
//
//                override fun onPermissionDenied(response: PermissionDeniedResponse?) {
//
//                    // To resume() is passed the value to return
//                    //continuation(DENIED)
//                    result = DENIED
//
//                }
//
//                override fun onPermissionRationaleShouldBeShown(
//                    permission: PermissionRequest?,
//                    token: PermissionToken?
//                ) {
//                    //super.onPermissionRationaleShouldBeShown(permission, token)
//                    //continuation(DIALOG)
//                    result = DIALOG
//                    val builder = AlertDialog.Builder(activity)
//
//                    builder.setMessage("El missatge de l'alerta")
//                    builder.setTitle("Títol")
//                    builder.setNegativeButton("No") { dialog, which ->
//                        Toast.makeText(activity, "You are not agree.", Toast.LENGTH_SHORT).show()
//                    }
//
//                    builder.setPositiveButton("Yes") { dialog, which ->
//                        Toast.makeText(activity, "You are agree.", Toast.LENGTH_SHORT).show()
//                    }
//
//                    // Finally, make the alert dialog using builder
//                    val dialog: AlertDialog = builder.create()
//
//                    // Display the alert dialog on app interface
//                    dialog.show()
//
//                }
//
//                // al ser la última línia és el valor de retorn de la lambda (en aquest cas Unit o void)
//            }).check()
//
//        return continuation(result)
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

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest,
                    token: PermissionToken?
                ) {
                    // This method will be called when the user rejects a permission request
                    // You must display a dialog box that explains to the user why the application needs this permission
                    token?.continuePermissionRequest()
                    result = false

//                    val builder = AlertDialog.Builder(activity)
//
//                    builder.setMessage("El missatge de l'alerta")
//                    builder.setTitle("Títol")
//                    builder.setNegativeButton("No") { dialog, which ->
//                        Toast.makeText(activity, "You are not agree.", Toast.LENGTH_SHORT).show()
//                    }
//
//                    builder.setPositiveButton("Yes") { dialog, which ->
//                        Toast.makeText(activity, "You are agree.", Toast.LENGTH_SHORT).show()
//                    }
//
//                    // Finally, make the alert dialog using builder
//                    val dialog: AlertDialog = builder.create()
//
//                    // Display the alert dialog on app interface
//                    dialog.show()

                }

            }).check()

        return result

    }

}