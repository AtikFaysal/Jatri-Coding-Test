package com.jatri.codingtest.di

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jatri.codingtest.network.NetworkHelper
import com.jatri.codingtest.network.apiConfig.ApiHelper
import com.jatri.codingtest.network.apiConfig.ApiHelperImpl
import com.jatri.codingtest.network.apiConfig.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule
{
    @Provides
    fun provideBaseUrl() = "http://api.openweathermap.org/"

    @Provides
    @Singleton
    fun provideOkHttpClient(helper: NetworkHelper): OkHttpClient {
        val interceptor: Interceptor = Interceptor { chain ->
            if(!helper.isNetworkConnected()) {
                Log.d("noNetworkError","undable to connect internet")
            }

            val original: Request = chain.request()
            val request: Request = original.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .method(original.method, original.body)
                .build()

            chain.proceed(request)
        }

        return OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiServices(retrofit: Retrofit) : ApiServices = retrofit.create(ApiServices::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl) : ApiHelper = apiHelper
}