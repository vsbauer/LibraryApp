package com.github.vsbauer.libraryapp.data

import android.util.Log
import com.github.vsbauer.libraryapp.data.models.Book
import javax.inject.Inject

class GoogleBooksRepository @Inject constructor(var service: BookApiService) : Repository {

    override suspend fun getBooks(search: String): List<Book> {
        try {
            return service.getBooks(search).bookDTOS.map {
                Log.d("!!!Repos", it.toString())
                val author = it.bookInfo.authors?.firstOrNull() ?: ""
                Book(
                    author,
                    it.bookInfo.title,
                    it.bookInfo.imageLinks.thumbnail,
                    it.bookInfo.infoLink
                )

            }
        } catch (e: Exception) {
            Log.e("!!!MainRepository", e.toString())
            return listOf()
        }
    }

}