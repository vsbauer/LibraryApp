package com.github.vsbauer.search.ui.data.networkDTO

import com.google.gson.annotations.SerializedName

data class ReadingModes(
    @SerializedName("image")
    val image: Boolean,
    @SerializedName("text")
    val text: Boolean
)