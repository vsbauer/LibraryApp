package com.github.vsbauer.libraryapp.data.networkDTO

import com.google.gson.annotations.SerializedName

data class PanelizationSummary(
    @SerializedName("containsEpubBubbles")
    val containsEpubBubbles: Boolean,
    @SerializedName("containsImageBubbles")
    val containsImageBubbles: Boolean
)