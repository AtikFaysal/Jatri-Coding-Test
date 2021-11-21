package com.jatri.codingtest.interfaces

import android.util.Log
import com.jatri.codingtest.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * @Created 11/14/2021 at 1:31 PM
 */
interface SafeApiCall
{
    suspend fun <T> safeApiCall(apiCall : suspend () -> T) : Resource<T>
    {
        return withContext(Dispatchers.IO) {
            try {
                Resource.success(apiCall.invoke())
            }catch (throwable : Throwable)
            {
                when (throwable) {
                    is HttpException -> Resource.error( throwable.response()?.errorBody().toString(), null)
                    else -> {
                        Log.d("noNetworkException", throwable.message.toString())
                        Resource.noNetworkException("Unable to connect internet, please retry.")
                    }
                }
            }
        }
    }
}