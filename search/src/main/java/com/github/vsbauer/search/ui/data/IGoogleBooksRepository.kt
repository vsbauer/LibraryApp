package com.github.vsbauer.search.ui.data

import com.github.vsbauer.core.models.Book


interface IGoogleBooksRepository {

    suspend fun getBooks(search: String): List<Book>
}
