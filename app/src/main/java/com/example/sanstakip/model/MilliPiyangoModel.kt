package com.example.sanstakip.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MilliPiyangoModel(
    @SerializedName("drawnNr") val drawNumber : Int? = 0,
    @SerializedName("drawDate") val drawDate : String? = "",
    @SerializedName("drawTime") val drawTime : String? = "",
    @SerializedName("drawnNumbers") val drawNumbers : ArrayList<Int>? = ArrayList(),
    @SerializedName("amortiNumber1") val firstAmortiNumber : String? = "",
    @SerializedName("amortiNumber2") val secondAmortiNumber : String? = "",
): Parcelable {
    fun strDrawNumber(): String {
        return "$drawNumber"
    }

    fun setDateAndTime(): String {
        return "$drawDate - $drawTime"
    }

    fun strDrawNumbers(): String {
        return "${drawNumbers?.get(0)} ${drawNumbers?.get(1)} ${drawNumbers?.get(2)} ${drawNumbers?.get(3)} ${drawNumbers?.get(4)} ${drawNumbers?.get(5)}"
    }

    fun strAmortiNumbers(): String {
        return "$firstAmortiNumber - $secondAmortiNumber"
    }
}

@Parcelize
data class MilliPiyangoDetailModel(
    @SerializedName("firstCategoryName") val firstCategoryName : String? = "",
    @SerializedName("firstCategoryWinning") val firstCategoryWinningNumbers : String? = "",
    @SerializedName("secondCategoryName") val secondCategoryName : String? = "",
    @SerializedName("secondCategoryWinning") val secondCategoryWinning : String? = "",
    @SerializedName("drawDate") val drawDate : String? = "",
    @SerializedName("categories") val categories : List<Category>? = listOf()
): Parcelable

@Parcelize
data class Category(
    @SerializedName("category") val categoryName : String? = "",
    @SerializedName("winningSeries") val winningSeries : List<String> = listOf()
): Parcelable