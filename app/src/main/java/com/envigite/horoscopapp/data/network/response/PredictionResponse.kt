package com.envigite.horoscopapp.data.network.response

import com.google.gson.annotations.SerializedName

class PredictionResponse {

    data class PredictionResponse(
        @SerializedName("date") val date: String,
        @SerializedName("horoscope") val horoscope: String,
        @SerializedName("sign") val sign: String
    )

}