package com.github.vsbauer.search.ui.data.networkDTO

import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currencyCode")
    val currencyCode: String
)