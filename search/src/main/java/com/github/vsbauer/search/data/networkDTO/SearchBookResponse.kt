package com.github.vsbauer.search.data.networkDTO

import com.google.gson.annotations.SerializedName

data class SearchBookResponse(
    @SerializedName("items")
    val bookDTOS: List<BookDTO>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int
)