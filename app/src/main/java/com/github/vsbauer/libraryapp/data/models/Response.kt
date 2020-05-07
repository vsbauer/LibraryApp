package com.github.vsbauer.libraryapp.data.models

data class Response(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)