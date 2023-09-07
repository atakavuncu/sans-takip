package com.example.sanstakip.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultModel(
    @SerializedName("numbersMatched") val matchedNumbers: String? = "",
    @SerializedName("totalWinners") val winnerCount: String? = "",
    @SerializedName("prizeWinner") val winnerPrize: String? = ""
): Parcelable {
    fun strMatchedNumbers() : String {
        return "$matchedNumbers Bilen Sayısı:"
    }

    fun strWinnerPrize() : String {
        winnerPrize?. let {
            if(winnerPrize.length >= 2 ) {
                val modifiedString = winnerPrize.dropLast(1)
                val lastIndex = modifiedString.length - 2
                return modifiedString.substring(0, lastIndex) + "," + modifiedString.substring(lastIndex) + " ₺"
            }
        }
        return "$winnerPrize ₺"
    }
}
