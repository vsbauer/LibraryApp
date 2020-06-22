package com.github.vsbauer.recommendation.ui.data.networkDTO

import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currencyCode")
    val currencyCode: String
)