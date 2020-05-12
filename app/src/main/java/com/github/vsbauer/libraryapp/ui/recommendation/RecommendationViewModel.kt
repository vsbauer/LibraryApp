package com.github.vsbauer.libraryapp.ui.recommendation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.github.vsbauer.libraryapp.data.GoogleBooksRepository
import com.github.vsbauer.libraryapp.data.models.Book

class RecommendationViewModel : ViewModel() {

    fun getBooks(search: String): LiveData<List<Book>> {
        return liveData { emit(GoogleBooksRepository.getBooks(search)) }
    }
}
