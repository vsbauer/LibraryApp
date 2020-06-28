package com.github.vsbauer.search.data

import android.util.Log
import com.github.vsbauer.core.models.GoogleBook
import javax.inject.Inject

class GoogleBooksRepository @Inject constructor(private val service: BookApiService) :
    IGoogleBooksRepository {

    override suspend fun getBooks(search: String): List<GoogleBook> {
        try {
            return service.getBooks(search).bookDTOS.map {
                Log.d("!!!Repos", it.toString())
                val author: String? = it.bookInfo.authors?.firstOrNull()
                GoogleBook(
                    author ?: "",
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