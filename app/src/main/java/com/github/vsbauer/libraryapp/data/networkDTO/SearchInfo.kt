package com.github.vsbauer.libraryapp.data.networkDTO

import com.google.gson.annotations.SerializedName

data class SearchInfo(
    @SerializedName("textSnippet")
    val textSnippet: String
)