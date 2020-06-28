package com.github.vsbauer.search.ui.data.networkDTO

import com.google.gson.annotations.SerializedName

data class OfferPrice(
    @SerializedName("amountInMicros")
    val amountInMicros: Double,
    @SerializedName("currencyCode")
    val currencyCode: String
)