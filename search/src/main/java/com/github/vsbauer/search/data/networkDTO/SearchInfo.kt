package com.github.vsbauer.search.data.networkDTO

import com.google.gson.annotations.SerializedName

data class SearchInfo(
    @SerializedName("textSnippet")
    val textSnippet: String
)