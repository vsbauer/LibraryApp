package com.github.vsbauer.search.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.github.vsbauer.core.models.Book
import com.github.vsbauer.search.data.IGoogleBooksRepository
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val repository: IGoogleBooksRepository) :
    ViewModel() {

    fun getBooks(search: String): LiveData<List<Book>> {
        return liveData { emit(repository.getBooks(search)) }
    }
}
