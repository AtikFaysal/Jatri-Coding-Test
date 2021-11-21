package com.jatri.codingtest.core

import android.app.Activity
import android.content.Context
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Atik Faysal (Android Developer)
 * Create on 7/6/2021
 * Email: mdatikfaysal@gmail.com
 * *** Happy Coding ***
 */
abstract class BaseAdapter<T : RecyclerView.ViewHolder, D> : RecyclerView.Adapter<T>() {

    protected lateinit var mContext: Context
    protected lateinit  var mActivity: Activity

    abstract fun setData(data: List<D>)
}