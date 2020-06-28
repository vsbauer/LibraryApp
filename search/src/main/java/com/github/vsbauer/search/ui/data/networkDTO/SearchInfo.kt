package com.github.vsbauer.search.ui.data.networkDTO

import com.google.gson.annotations.SerializedName

data class SearchInfo(
    @SerializedName("textSnippet")
    val textSnippet: String
)