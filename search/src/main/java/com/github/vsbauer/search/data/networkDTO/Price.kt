package com.github.vsbauer.search.data.networkDTO

import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currencyCode")
    val currencyCode: String
)