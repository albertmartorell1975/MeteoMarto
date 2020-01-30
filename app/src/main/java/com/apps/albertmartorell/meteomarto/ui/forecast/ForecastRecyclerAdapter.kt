package com.apps.albertmartorell.meteomarto.ui.forecast

import albertmartorell.com.domain.cityforecast.ForecastDomain
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.apps.albertmartorell.meteomarto.R
import com.apps.albertmartorell.meteomarto.framework.db.model.ForecastEntity
import com.apps.albertmartorell.meteomarto.ui.inflate
import com.apps.albertmartorell.meteomarto.ui.loadIconsWeather

class ForecastRecyclerAdapter(private val forecastList: List<ForecastDomain>) :
    RecyclerView.Adapter<ForecastRecyclerAdapter.ForecastHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ForecastHolder {

        val inflatedView = parent.inflate(R.layout.lyt_frg_city_forecast_recycler_row, false)
        return ForecastHolder(inflatedView)

    }

    override fun getItemCount(): Int {

        return forecastList.size

    }

    override fun onBindViewHolder(holder: ForecastRecyclerAdapter.ForecastHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    // ViewHolder is in charge of setting the value to the views
    class ForecastHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var forecastEntity: ForecastEntity? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

        fun bind(_forecastEntity: ForecastEntity) {

            forecastEntity = _forecastEntity
            (view as ImageView).loadIconsWeather(forecastEntity?.weatherIcon)


            //Picasso.with(view.context).load(photo.url).into(view.itemImage)
            //view.itemDate.text = photo.humanDate
            //view.itemDescription.text = photo.explanation
        }

        companion object {
            //5
            private val PHOTO_KEY = "PHOTO"

        }

    }

}