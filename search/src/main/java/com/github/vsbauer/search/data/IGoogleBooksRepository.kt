package com.github.vsbauer.search.data

import com.github.vsbauer.core.models.GoogleBook


interface IGoogleBooksRepository {

    suspend fun getBooks(search: String): List<GoogleBook>
}
