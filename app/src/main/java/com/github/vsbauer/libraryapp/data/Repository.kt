package com.github.vsbauer.libraryapp.data

import com.github.vsbauer.libraryapp.data.models.Book

interface Repository {

    suspend fun getBooks(search: String): List<Book>
}
