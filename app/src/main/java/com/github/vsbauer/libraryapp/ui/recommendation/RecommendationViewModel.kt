package com.github.vsbauer.libraryapp.ui.recommendation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.github.vsbauer.libraryapp.data.IGoogleBooksRepository
import com.github.vsbauer.libraryapp.data.models.Book
import javax.inject.Inject

class RecommendationViewModel @Inject constructor(private val repository: IGoogleBooksRepository) :
    ViewModel() {

    fun getBooks(search: String): LiveData<List<Book>> {
        return liveData { emit(repository.getBooks(search)) }
    }
}
