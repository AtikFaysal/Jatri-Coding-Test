package com.jatri.codingtest.ui.view

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.jatri.codingtest.R
import com.jatri.codingtest.adapter.WeatherListAdapter
import com.jatri.codingtest.core.BaseActivity
import com.jatri.codingtest.core.BaseFragment
import com.jatri.codingtest.data.model.WeatherModel
import com.jatri.codingtest.databinding.LayoutItemListBinding
import com.jatri.codingtest.ui.viewmodel.WeatherViewModel
import com.jatri.codingtest.utils.RecyclerViewUtils
import com.jatri.codingtest.utils.Status
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 */

@AndroidEntryPoint
class WeatherListFragment : BaseFragment<LayoutItemListBinding, WeatherViewModel>()
{
    private lateinit var binding: LayoutItemListBinding
    private val viewModel : WeatherViewModel by activityViewModels()
    private var adapter = WeatherListAdapter(arrayListOf())

    private lateinit var progressDialog : ProgressDialog

    override val layoutId: Int
        get() = R.layout.layout_item_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = viewDataBinding
        binding.lifecycleOwner = this
        binding.items = mViewModel
        initialize()
        weatherListObserver()
    }

    override fun initialize() {
        mContext = requireContext()
        (activity as BaseActivity).setToolbarTitle("Weather app")//set toolbar title
        RecyclerViewUtils.verticalOrientedRecyclerView(mContext, binding.recyclerView).adapter = adapter
        progressDialog = ProgressDialog(mContext)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Loading...")
        mViewModel.isLoading.observe(viewLifecycleOwner, {
            if(it) progressDialog.show()
            else progressDialog.dismiss()
        })
    }

    private fun weatherListObserver()
    {
        mViewModel.weatherModelList.observe(viewLifecycleOwner, {
            when(it.status){
                Status.SUCCESS-> it.data?.let { user -> renderList(user)}
                Status.LOADING -> {}
                Status.ERROR -> Log.d("errorResponse",it.message.toString())
                Status.NoNetworkException -> Log.d("networkErrorResponse",it.message.toString())
            }
        })
    }

    private fun renderList(items : List<WeatherModel>)
    {
        adapter.addData(items)
        adapter.notifyDataSetChanged()
    }
}

