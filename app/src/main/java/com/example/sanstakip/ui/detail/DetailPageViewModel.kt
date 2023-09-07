package com.example.sanstakip.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sanstakip.api.ApiService
import com.example.sanstakip.api.ServiceGenerator
import com.example.sanstakip.base.BaseViewModel
import com.example.sanstakip.base.Event
import com.example.sanstakip.model.SayisalSuperDetailModel
import com.example.sanstakip.model.SayisalSuperModel
import com.example.sanstakip.ui.homepage.HomePageEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailPageViewModel @Inject constructor() : ViewModel() {

    private val _detailModelLiveData: MutableLiveData<SayisalSuperDetailModel> = MutableLiveData()
    val detailModelLiveData: LiveData<SayisalSuperDetailModel> = _detailModelLiveData

    fun fetchDetailData(type: String, drawNr: Int, drawYear: Int) {
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getDrawDetails(type, drawNr, drawYear)

        call.enqueue(object : Callback<SayisalSuperDetailModel> {
            override fun onResponse(
                call: Call<SayisalSuperDetailModel>,
                response: Response<SayisalSuperDetailModel>
            ) {
                if (response.isSuccessful) {
                    val dataModel: SayisalSuperDetailModel? = response.body()
                    dataModel?.let { dataModel ->
                        _detailModelLiveData.value = dataModel
                    }
                }
            }

            override fun onFailure(call: Call<SayisalSuperDetailModel>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}