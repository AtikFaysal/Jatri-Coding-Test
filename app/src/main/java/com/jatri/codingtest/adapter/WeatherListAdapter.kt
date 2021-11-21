package com.jatri.codingtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.jatri.codingtest.R
import com.jatri.codingtest.data.model.WeatherData
import com.jatri.codingtest.ui.view.WeatherDetailsFragment.Companion.weatherInfo
import kotlinx.android.synthetic.main.model_weather.view.*

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 */
class WeatherListAdapter(
    private val items: ArrayList<WeatherData>
) : RecyclerView.Adapter<WeatherListAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: WeatherData) {
            itemView.tv_city_name.text = model.name
            itemView.tv_temperature.text = "${model.main.temp} \u2103"
            itemView.tv_description.text = "Humidity: ${model.main.humidity}"

            itemView.setOnClickListener {
                weatherInfo = model
                Navigation.createNavigateOnClickListener(R.id.action_weatherListFragment_to_weatherDetailsFragment).onClick(itemView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.model_weather, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(items[position])

    fun addData(list: List<WeatherData>) {
        items.addAll(list)
    }
}