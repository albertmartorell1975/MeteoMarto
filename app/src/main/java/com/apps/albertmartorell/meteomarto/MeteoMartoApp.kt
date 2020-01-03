package com.apps.albertmartorell.meteomarto

import albertmartorell.com.data.repositories.WeatherRepository
import android.app.Application
import com.apps.albertmartorell.meteomarto.framework.db.ImpWeatherDeviceSource
import com.apps.albertmartorell.meteomarto.framework.server.ImpWeatherServerSource

class MeteoMartoApp : Application() {

    // It is marked with "late-init" to crash if it is not initialized before use (and that's exactly what we want)
//    lateinit var meteoMartoDatabase: MeteoMartoDatabase
//    val weatherRepository =
//        WeatherRepository(ImpWeatherServerSource(), ImpWeatherDeviceSource(this))

    override fun onCreate() {

        super.onCreate()
        val weatherRepository =
            WeatherRepository(ImpWeatherServerSource(), ImpWeatherDeviceSource(this))

//        meteoMartoDatabase =
//            Room.databaseBuilder(this, MeteoMartoDatabase::class.java, "MeteoMartoDatabase").build()

    }

    // This injects all the dependencies into the ViewModelFactory. It creates ViewModels in the app and passes interactor dependencies to them
//    MajesticViewModelFactory.inject(
//    this,
//    Interactors(
//    AddBookmark(bookmarkRepository),
//    GetBookmarks(bookmarkRepository),
//    RemoveBookmark(bookmarkRepository),
//    AddDocument(documentRepository),
//    GetDocuments(documentRepository),
//    RemoveDocument(documentRepository),
//    GetOpenDocument(documentRepository),
//    SetOpenDocument(documentRepository)
//    )
//    )
}