package com.github.vsbauer.search.ui.data.networkDTO

import com.google.gson.annotations.SerializedName

data class BookDTO(
    @SerializedName("accessInfo")
    val accessInfo: AccessInfo,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("saleInfo")
    val saleInfo: SaleInfo,
    @SerializedName("searchInfo")
    val searchInfo: SearchInfo,
    @SerializedName("selfLink")
    val selfLink: String,
    @SerializedName("volumeInfo")
    val bookInfo: BookInfo
)