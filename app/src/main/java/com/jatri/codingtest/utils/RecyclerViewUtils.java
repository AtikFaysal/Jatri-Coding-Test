package com.jatri.codingtest.utils;

import android.content.Context;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Date 1/16/2021.
 * Created by Md Atik Faysal(Android Developer)
 */
public class RecyclerViewUtils
{
    /**
     * ...vertical oriented recycler view
     * @param context application context
     * @param recyclerView recycler view object
     * @return modified recycler view object
     */
    public static RecyclerView verticalOrientedRecyclerView(Context context, RecyclerView recyclerView)
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setHasFixedSize(true);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return recyclerView;
    }

    /**
     * ...vertical oriented recycler view
     * @param context application context
     * @param recyclerView recycler view object
     * @return modified recycler view object
     */
    public static RecyclerView horizontalOrientedRecyclerView(Context context, RecyclerView recyclerView)
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setHasFixedSize(true);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return recyclerView;
    }

    /**
     * ...horizontal oriented multiple column recycler view
     * @param context application context
     * @param recyclerView recycler view object
     * @param column number of column
     * @return modified recycler view object
     */
    public static RecyclerView horizontalColumnRecyclerView(Context context, RecyclerView recyclerView, int column)
    {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(context, column));
        recyclerView.setNestedScrollingEnabled(false);

        return recyclerView;
    }

    /**
     * ...vertical oriented recycler view
     * @param recyclerView recycler view object
     * @param layoutManager linear layout manager
     * @return modified recycler view object
     */
    public static RecyclerView verticalOrientedRecyclerView(RecyclerView recyclerView,LinearLayoutManager layoutManager)
    {
        recyclerView.setHasFixedSize(true);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return recyclerView;
    }
}
