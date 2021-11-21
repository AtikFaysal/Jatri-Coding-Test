package com.jatri.codingtest.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jatri.codingtest.data.model.WeatherModel
import com.jatri.codingtest.data.repository.WeatherRepository
import com.jatri.codingtest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 */
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val  repository: WeatherRepository
    ) : ViewModel()
{
    private val _weatherList = MutableLiveData<Resource<List<WeatherModel>>>()
    val weatherModelList : LiveData<Resource<List<WeatherModel>>>
        get() = _weatherList

    var isLoading = MutableLiveData(false)

    init {
        fetchUserList()
    }

    private fun fetchUserList()
    {
        viewModelScope.launch{
            isLoading.postValue(true)
            _weatherList.postValue(Resource.loading(null))
            repository.getWeatherList().let {
                it.data?.let { response ->
                    if (response.isSuccessful) {
                        _weatherList.postValue(Resource.success(response.body()))
                    } else _weatherList.postValue(Resource.error(response.errorBody().toString(), null))
                }
            }
            isLoading.postValue(false)
        }
    }
}