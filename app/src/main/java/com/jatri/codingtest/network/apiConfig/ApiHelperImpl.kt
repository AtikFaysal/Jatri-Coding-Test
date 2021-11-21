package com.jatri.codingtest.network.apiConfig

import com.jatri.codingtest.data.model.WeatherModel
import retrofit2.Response
import javax.inject.Inject

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * @Created 11/9/2021 at 1:54 PM
 */
class ApiHelperImpl @Inject constructor(private val apiService : ApiServices) : ApiHelper
{
    override suspend fun getWeatherList(): Response<List<WeatherModel>> = apiService.getWeatherList()
}