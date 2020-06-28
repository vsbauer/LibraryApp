package com.github.vsbauer.search.ui.data.networkDTO

import com.google.gson.annotations.SerializedName

data class Offer(
    @SerializedName("finskyOfferType")
    val finskyOfferType: Int,
    @SerializedName("listPrice")
    val offerPrice: OfferPrice,
    @SerializedName("retailPrice")
    val retailPrice: OfferPrice
)