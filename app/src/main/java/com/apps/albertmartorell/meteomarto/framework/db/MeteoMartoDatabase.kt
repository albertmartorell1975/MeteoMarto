package com.apps.albertmartorell.meteomarto.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.apps.albertmartorell.meteomarto.framework.db.daos.WeatherDao
import com.apps.albertmartorell.meteomarto.framework.db.entities.*

/**
 *
 * The database below defines a class that has 7 tables and 1 DAO class that is used to access it.
 * There is no limit on the number of Entity or Dao classes but they must be unique within the Database.
 *
 * Instead of running queries on the database directly, you are highly recommended to create Dao classes.
 * Using Dao classes will allow you to abstract the database communication in a more logical layer which will be much easier to mock in tests (compared to running direct SQL queries).
 * It also automatically does the conversion from Cursor to your application data classes so you don't need to deal with lower level database APIs for most of your data access.
 * Room also verifies all of your queries in Dao classes while the application is being compiled so that if there is a problem in one of the queries, you will be notified instantly.
 */
@Database(
    entities = [CityEntity::class, CloudsEntity::class, CoordinatesEntity::class, MainEntity::class, SysEntity::class, WeatherEntity::class, WindEntity::class],
    version = 1
)
abstract class MeteoMartoDatabase : RoomDatabase() {

    //A function or a property to be tied to a class rather than to instances of it
    // (similar to @staticmethod in Python), you can declare it inside a companion object:
    companion object {

        private var instance: MeteoMartoDatabase? = null

        private fun createDatabase(context: Context): MeteoMartoDatabase =
            Room.databaseBuilder(
                context,
                MeteoMartoDatabase::class.java,
                "MeteoMartoDatabase"
            ).build()

        fun getInstance(context: Context): MeteoMartoDatabase =
            (instance ?: createDatabase(context).also
            { instance = it })

    }

    abstract fun weatherDao(): WeatherDao

}