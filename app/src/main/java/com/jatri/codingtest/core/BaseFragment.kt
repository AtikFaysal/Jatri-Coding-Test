package com.jatri.codingtest.core

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.jatri.codingtest.interfaces.InitComponent

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * Created 11/9/2021 at 11:56 AM
 */
abstract class BaseFragment <T : ViewDataBinding, V : ViewModel> : Fragment() , InitComponent
{

    protected lateinit var loadingDialog : AlertDialog
    protected lateinit var mContext : Context
    protected lateinit var mActivity : Activity
    protected lateinit var baseActivity: BaseActivity

    protected lateinit var mRootView: View
    protected lateinit var  viewDataBinding: T
    protected lateinit var mViewModel: V

    /**
     * @return layout resource id
     */
    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater,layoutId, container, false)
        mRootView = viewDataBinding.root
        hideOrVisibleLoading()
        return mRootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        return super.onCreateAnimation(transit, enter, nextAnim)
    }

    override fun onDetach() {
        super.onDetach()
        //hideKeyboard(requireActivity())
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        //hideKeyboard(requireActivity())
        //hideKeyboard()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        //hideKeyboard()
    }

    /**
     * ...initialize all component
     * ...create object
     * ...call some necessary method
     */
    abstract override fun initialize()


    /**
     * ...Display a snackBar
     * ...If any error is encountered, then show this SnackBar
     * @param view root view
     */
    fun errorSnackBar(view: View, message: String)
    {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

    /**
     * ...disable button
     * @param button button view
     */
    protected open fun onButtonDisable(button: Button) {
        button.isClickable = false
    }

    /**
     * ...disable button
     * @param button button view
     */
    protected open fun onButtonDisable(button: TextView) {
        button.isClickable = false
    }

    /**
     * ...enable button
     * @param button button view
     */
    protected open fun onButtonEnable(button: Button) {
        button.isClickable = true
    }

    /**
     * ...enable button
     * @param button button view
     */
    protected open fun onButtonEnable(button: TextView) {
        button.isClickable = true
    }

    /**
     * ...hide and visible loading progress dialog
     * ...while value is true then visible progress dialog
     * ...otherwise dismiss progress dialog
     */
    protected open fun hideOrVisibleLoading(){}

    private fun hideKeyboard() {
        val view = mActivity.currentFocus
        if (view != null) {
            val imm = mActivity.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun showKeyboard() {
        val imm = mActivity.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }
}