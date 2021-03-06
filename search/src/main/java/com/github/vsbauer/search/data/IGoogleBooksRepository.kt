package com.github.vsbauer.search.data

import com.github.vsbauer.core.models.Book


interface IGoogleBooksRepository {

    suspend fun getBooks(search: String): List<Book>
}
