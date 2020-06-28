package com.github.vsbauer.search.data.networkDTO

import com.google.gson.annotations.SerializedName

data class SaleInfo(
    @SerializedName("buyLink")
    val buyLink: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("isEbook")
    val isEbook: Boolean,
    @SerializedName("listPrice")
    val price: Price,
    @SerializedName("offers")
    val offers: List<Offer>,
    @SerializedName("retailPrice")
    val retailPrice: Price,
    @SerializedName("saleability")
    val saleability: String
)