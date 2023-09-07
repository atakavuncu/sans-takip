package com.example.sanstakip.ui.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sanstakip.api.ApiService
import com.example.sanstakip.api.ServiceGenerator
import com.example.sanstakip.base.BaseViewModel
import com.example.sanstakip.base.Event
import com.example.sanstakip.model.SayisalSuperModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor() : BaseViewModel<HomePageEvent>() {

    fun fetchData(type: String) : LiveData<ArrayList<SayisalSuperModel>>{
        val _dataModelLiveData: MutableLiveData<ArrayList<SayisalSuperModel>> = MutableLiveData()
        val dataModelLiveData: LiveData<ArrayList<SayisalSuperModel>> = _dataModelLiveData
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getLoto(type)

        call.enqueue(object : Callback<ArrayList<SayisalSuperModel>> {
            override fun onResponse(
                call: Call<ArrayList<SayisalSuperModel>>,
                response: Response<ArrayList<SayisalSuperModel>>
            ) {
                if (response.isSuccessful) {
                    val dataModel: ArrayList<SayisalSuperModel>? = response.body()
                    dataModel?.let { dataModel ->
                        _dataModelLiveData.value = dataModel
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<SayisalSuperModel>>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return dataModelLiveData
    }

    var onDetailClick: (SayisalSuperModel) -> Unit = {
        event.value = Event(HomePageEvent.SelectedLotoModel(it))
    }
}