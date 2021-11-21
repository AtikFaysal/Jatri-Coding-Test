package com.jatri.codingtest.core

import android.content.Context
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jatri.codingtest.interfaces.InitComponent
import io.github.inflationx.viewpump.ViewPumpContextWrapper

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * Created 11/9/2021 at 11:56 AM
 */
abstract class BaseActivity : AppCompatActivity() , InitComponent
{
    /**
     * ...initialize all component
     * ...create object
     * ...call some necessary method
     */
    abstract override fun initialize()

    abstract fun setToolbarTitle(title: String)

    /**
     * ...set toolbar title
     * ...modify title and textView if needed
     * @param title toolbar title
     * @param tvTitle textView object
     */
    fun setToolbarTitle(title: String, tvTitle: TextView)
    {
        tvTitle.text = title
    }

    /**
     * Override Method to active calligraphy font in this activity
     * @param newBase - activity base
     */
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }
}