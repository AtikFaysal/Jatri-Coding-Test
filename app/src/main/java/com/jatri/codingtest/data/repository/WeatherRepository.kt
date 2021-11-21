package com.jatri.codingtest.data.repository

import com.jatri.codingtest.interfaces.SafeApiCall
import com.jatri.codingtest.network.apiConfig.ApiHelper
import javax.inject.Inject

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 */
class WeatherRepository @Inject constructor(private val apiHelper: ApiHelper) : SafeApiCall
{
   // suspend fun getUsers() = apiHelper.getUsers()

    suspend fun getWeatherList() = safeApiCall{
        apiHelper.getWeatherList()
    }
}