package com.jatri.codingtest.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 */
class WeatherModel {
    @SerializedName("cod") val status = 0
    @SerializedName("count") val count = 0
    @SerializedName("list") val listData = ArrayList<WeatherData>()
}

class WeatherData{
    @SerializedName("id") val id = ""
    @SerializedName("name") val name = ""
    @SerializedName("dt") val dt = ""
    //@SerializedName("rain")  var rain : String ?= null
    //@SerializedName("snow")  var snow : String ?= null
    @SerializedName("coord") lateinit var coordinate : CoordinateData
    @SerializedName("main") lateinit var main : MainData
    @SerializedName("wind") lateinit var wind : WindData
    //@SerializedName("sys") lateinit var sys : SysData
    //@SerializedName("clouds") lateinit var clouds : CloudsData
    //@SerializedName("weather") val weather = ArrayList<Weather>()
}

class CoordinateData{
    @SerializedName("lat") val latitude = ""
    @SerializedName("lon") val longitude = ""
}

class WindData{
    @SerializedName("speed") val speed = ""
    @SerializedName("deg") val deg = ""
}

class SysData{
    @SerializedName("country") val country = ""
}

class CloudsData{
    @SerializedName("all") val all = ""
}


class MainData{
    @SerializedName("temp") val temp = ""
    @SerializedName("feels_like") val feelsLike = ""
    @SerializedName("temp_min") val tempMin = ""
    @SerializedName("temp_max") val tempMax = ""
    @SerializedName("pressure") val pressure = ""
    @SerializedName("humidity") val humidity = ""
}

class Weather{
    @SerializedName("id") val id = ""
    @SerializedName("main") val main = ""
    @SerializedName("description") val description = ""
    @SerializedName("icon") val icon = ""
}