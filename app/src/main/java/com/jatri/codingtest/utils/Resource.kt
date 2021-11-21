package com.jatri.codingtest.utils

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * @Created 11/9/2021 at 11:54 AM
 */
data class Resource<out T>(val status : Status, val data : T?, val message : String?)
{
    companion object{
        fun <T> success(data : T?) : Resource<T>{
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(message : String, data : T?) : Resource<T>{
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data : T?) : Resource<T>{
            return Resource(Status.LOADING, data, null)
        }

        fun <T> noNetworkException(message : String) : Resource<T>{
            return Resource(Status.NoNetworkException, null, message)
        }
    }
}