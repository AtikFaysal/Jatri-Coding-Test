package com.jatri.codingtest.network.apiConfig

import com.jatri.codingtest.data.model.WeatherModel
import retrofit2.Response

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * @Created 11/9/2021 at 1:54 PM
 */
interface ApiHelper
{
    suspend fun getWeatherList(): Response<WeatherModel>
}