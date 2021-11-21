package com.jatri.codingtest.network.apiConfig

import com.jatri.codingtest.data.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * @Created 11/9/2021 at 1:54 PM
 */
interface ApiServices
{
    @GET("data/2.5/find?lat=23.68&lon=90.35&cnt=50&appid=e384f9ac095b2109c751d95296f8ea76")
    suspend fun getWeatherList(): Response<WeatherModel>
}