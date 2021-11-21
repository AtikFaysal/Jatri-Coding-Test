package com.jatri.codingtest.ui.view

import android.annotation.SuppressLint
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.jatri.codingtest.R
import com.jatri.codingtest.core.BaseActivity
import com.jatri.codingtest.core.BaseFragment
import com.jatri.codingtest.data.model.WeatherData
import com.jatri.codingtest.databinding.LayoutDetailsBinding
import com.jatri.codingtest.ui.viewmodel.WeatherViewModel
import java.lang.Exception
import java.util.*

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * @Created 11/21/2021 at 3:25 PM
 */
class WeatherDetailsFragment : BaseFragment<LayoutDetailsBinding, WeatherViewModel>(),
    OnMapReadyCallback,
    ConnectionCallbacks,
    OnConnectionFailedListener
{
    companion object{
        lateinit var weatherInfo : WeatherData
    }

    private lateinit var fragmentActivity : FragmentActivity
    private var latitude = 0.0
    private var longitude = 0.0
    private var position: LatLng? = null

    private lateinit var binding: LayoutDetailsBinding
    private val viewModel : WeatherViewModel by activityViewModels()

    override val layoutId: Int
        get() = R.layout.layout_details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = viewDataBinding
        binding.lifecycleOwner = this
        binding.details = mViewModel
        (activity as BaseActivity).setToolbarTitle("Weather Details")//set toolbar title
        initialize()
        renderWeatherInfo()
    }

    override fun initialize() {
        mContext = requireContext()
        fragmentActivity = mContext as FragmentActivity
        val fm = fragmentActivity.supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        fm?.getMapAsync(this)
    }

    @SuppressLint("SetTextI18n")
    private fun renderWeatherInfo()
    {
        binding.tvCityName.text = weatherInfo.name
        binding.tvDescription.text = weatherInfo.dt
        binding.tvHumidity.text = "Humidity: ${weatherInfo.main.humidity}"
        binding.tvWindSpeed.text = "Wind: ${weatherInfo.wind.speed}"
        binding.tvMaxTemp.text = "Max Temp: ${weatherInfo.main.tempMax}  ℃"
        binding.tvMinTemp.text = "Max Temp: ${weatherInfo.main.tempMin}  ℃"
        binding.tvTemp.text = "Max Temp: ${weatherInfo.main.temp}  ℃"
    }

    override fun onMapReady(googleMap: GoogleMap) {
        latitude = weatherInfo.coordinate.latitude.toDouble()
        longitude = weatherInfo.coordinate.longitude.toDouble()

        //Log.d("print_lat_lng", "${weatherInfo.coordinate.latitude} ${weatherInfo.coordinate.longitude}")

        position = LatLng(latitude, longitude)
        val options = MarkerOptions()
        options.position(position!!)

        options.title("Location")
        try {
            val geocoder = Geocoder(mContext, Locale.getDefault())
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            val cityName = addresses[0].getAddressLine(0)
            val stateName = addresses[0].getAddressLine(1)
            options.snippet("$cityName,$stateName")
        } catch (ex: Exception) {
            Log.d("mapException", ex.toString())
            ex.message
            options.snippet("Latitude:$latitude,Longitude:$longitude")
        }
        googleMap.addMarker(options)
        googleMap.addMarker(options.position(LatLng(latitude, longitude)))
        val updatePosition = CameraUpdateFactory.newLatLng(position!!)

        // Creating CameraUpdate object for zoom
        val updateZoom = CameraUpdateFactory.zoomTo(16f)

        // Updating the camera position to the user input latitude and longitude
        googleMap.moveCamera(updatePosition)

        // Applying zoom to the marker position
        googleMap.animateCamera(updateZoom)
    }

    override fun onConnected(p0: Bundle?) {}

    override fun onConnectionSuspended(p0: Int) {}

    override fun onConnectionFailed(p0: ConnectionResult) {}
}