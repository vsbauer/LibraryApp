package com.github.vsbauer.libraryapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.github.vsbauer.libraryapp.data.models.Book

object GoogleBooksRepository {

    fun getBooks(search: String): LiveData<List<Book>> = liveData {
        try {
            emit(BookApiService.newInstance().getBooks(search).bookDTOS.map {
                Log.d("!!!Repos", it.toString())
                val author = it.bookInfo.authors?.firstOrNull() ?: ""
                Book(
                    author,
                    it.bookInfo.title,
                    it.bookInfo.imageLinks.thumbnail,
                    it.bookInfo.infoLink
                )

            })
        } catch (e: Exception) {
            Log.e("!!!MainRepository", e.toString())
        }
    }

}