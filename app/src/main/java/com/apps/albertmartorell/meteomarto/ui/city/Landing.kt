package com.apps.albertmartorell.meteomarto.ui.city

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.apps.albertmartorell.meteomarto.R
import com.apps.albertmartorell.meteomarto.databinding.LytActLandingBinding
import com.apps.albertmartorell.meteomarto.ui.PermissionChecker
import com.apps.albertmartorell.meteomarto.ui.RegionRepository
import com.apps.albertmartorell.meteomarto.ui.toRegion
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume

class Landing : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var job: Job
    private lateinit var binding: LytActLandingBinding
    private val regionRepository: RegionRepository by lazy {
        RegionRepository(this)
    }
    // to get the current user location
    //private lateinit var fusedLocationClient: FusedLocationProviderClient
    // it checks if the user permission is granted
    //private val coarsePermissionChecker = PermissionChecker(this, ACCESS_COARSE_LOCATION)
    // to get a direction from location to find out the country
    //private lateinit var geoCoder: Geocoder

    //companion object {

    //    private val DEFAULT_REGION = "US"

    //}

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        job = Job()
        binding = DataBindingUtil.setContentView(this, R.layout.lyt_act_landing)
        binding.lifecycleOwner = this

        //geoCoder = Geocoder(this)
        //fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Les Corutines faciliten el treball amb tasques asíncrones. Podem escriure codi asícnron, que es feia amb el patró callback,
        // però en utilitzant un estil sequencial. El valor de retorn d'una funció proporcionarà el resultat de la crida asíncrona

        // Es basen en funcions de suspenció, les quals poden suspendre l'execució de la coroutina, i recuperar l'execució quan
        // la funció de suspensió ha acabat.

        // Les funcions de suspensió bloquejen l'execució de la corrutina, i es poden executar en un fil diferent. Només es poden executar
        // en una corrutina

        // Aquesta corrutina s'executa en el fil principal, però podem dir que certes funcions a dins
        // seu s'excecutin en un altre fil (p.e el secundari o IO)
        job = launch {

            binding.progressBar.visibility = View.VISIBLE
            withContext(Dispatchers.IO) {
                regionRepository.findLastRegion()
            }
            //val myDeferred = async(Dispatchers.IO) { findLastRegion() }
            //myDeferred.await()
            binding.progressBar.visibility = View.GONE

        }

    }

    override fun onDestroy() {

        job.cancel()
        super.onDestroy()

    }

    /**
    suspend fun findLastRegion(): String = findLastLocation().toRegion(geoCoder, DEFAULT_REGION)

    private suspend fun findLastLocation(): Location? {

    val success = coarsePermissionChecker.request()
    return if (success) lastLocationSuspended() else null

    }

    // Recuperem la darrer localització, i quan l'acabem la tornem com a resultat de la funció de suspenció
    private suspend fun lastLocationSuspended(): Location? =

    suspendCancellableCoroutine { continuation ->
    fusedLocationClient.lastLocation.addOnCompleteListener { continuation.resume(it.result) }

    }
     **/

}