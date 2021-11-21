package com.jatri.codingtest.utils

import android.content.Context
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 */
fun Context.verticalOrientedRecyclerView(recyclerView: RecyclerView): RecyclerView {
    val layoutManager = LinearLayoutManager(this)
    recyclerView.setHasFixedSize(true)
    layoutManager.orientation = LinearLayoutManager.VERTICAL
    recyclerView.layoutManager = layoutManager
    recyclerView.itemAnimator = DefaultItemAnimator()
    return recyclerView
}