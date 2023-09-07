package com.example.sanstakip.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class SayisalSuperModel(
    @SerializedName("lotteryName") val type : String = "",
    @SerializedName("drawnNr") val drawNumber : Int? = 0,
    @SerializedName("drawDate") val drawDate : String? = "",
    @SerializedName("drawTime") val drawTime : String? = "",
    @SerializedName("drawNumbers") val drawNumbers : ArrayList<Int>? = ArrayList(),
): Parcelable {
    fun setTypeName() : String {
        if (type == "SAYISAL")
            return "sayisaloto"
        if (type == "SUPERLOTO")
            return "superloto"
        return ""
    }

    fun strDrawNumber(): String {
        return "Çekiliş No: $drawNumber"
    }

    fun setDateAndTime(): String {
        return "$drawDate - $drawTime"
    }

    fun strDrawNumbers(): String {
        return drawNumbers?.joinToString(" ") ?: ""
    }
}

@Parcelize
data class SayisalSuperDetailModel(
    @SerializedName("tableResult") val tableResult: @RawValue ArrayList<ResultModel>? = ArrayList()
): Parcelable
