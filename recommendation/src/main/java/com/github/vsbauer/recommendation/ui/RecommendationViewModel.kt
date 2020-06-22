package com.github.vsbauer.recommendation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.github.vsbauer.core.models.Book
import com.github.vsbauer.recommendation.ui.data.IGoogleBooksRepository
import javax.inject.Inject

class RecommendationViewModel @Inject constructor(private val repository: IGoogleBooksRepository) :
    ViewModel() {

    fun getBooks(search: String): LiveData<List<Book>> {
        return liveData { emit(repository.getBooks(search)) }
    }
}
