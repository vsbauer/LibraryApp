package com.github.vsbauer.recommendation.ui.data.networkDTO

import com.google.gson.annotations.SerializedName

data class SearchInfo(
    @SerializedName("textSnippet")
    val textSnippet: String
)