package com.example.sanstakip.api

import com.example.sanstakip.model.MilliPiyangoDetailModel
import com.example.sanstakip.model.MilliPiyangoModel
import com.example.sanstakip.model.SayisalSuperDetailModel
import com.example.sanstakip.model.SayisalSuperModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("result.millipiyango.8.2023.json")
    fun getMilliPiyango(): Call<MilliPiyangoModel>

    @GET("drawdetails.millypiyango.{drawNr}.{drawYear}.json")
    fun getMilliPiyangoDetails(
        @Path("drawNr") drawNr: Int,
        @Path("drawYear") drawYear: Int
    ): Call<MilliPiyangoDetailModel>

    @GET("result.{type}.8.2023.json")
    fun getLoto(
        @Path("type") type: String,
    ): Call<ArrayList<SayisalSuperModel>>

    @GET("drawdetails.{type}.{drawNr}.{drawYear}.json")
    fun getDrawDetails(
        @Path("type") type: String,
        @Path("drawNr") drawNr: Int,
        @Path("drawYear") drawYear: Int
    ): Call<SayisalSuperDetailModel>
}


/*
milli piyango -> https://www.millipiyangoonline.com/sisalsans/result.millipiyango.8.2023.json
sayisal loto -> https://www.millipiyangoonline.com/sisalsans/result.sayisaloto.8.2023.json
super loto -> https://www.millipiyangoonline.com/sisalsans/result.superloto.8.2023.json
2:57
https://www.millipiyangoonline.com/sisalsans/drawdetails.superloto.105.2023.json
2:58
https://www.millipiyangoonline.com/sisalsans/drawdetails.$type.$drawNr.$drawYear

sayisal loto --> type = sayisaloto

milli piyango --> type = millypiyango

süper loto --> type = superloto

 */