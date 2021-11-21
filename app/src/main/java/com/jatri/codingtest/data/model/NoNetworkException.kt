package com.jatri.codingtest.data.model

import java.io.IOException

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 */
class NoNetworkException internal constructor() : IOException()
{
    val errorCode: Int get() = 1000

    val errorMessage: String get() = "Please check internet connection"
}