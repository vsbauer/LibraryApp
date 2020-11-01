package com.github.vsbauer.toread.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.github.vsbauer.core.models.Book
import com.github.vsbauer.library.db.DatabaseRepository
import javax.inject.Inject

class ToReadViewModel @Inject constructor(private val databaseRepository: DatabaseRepository) :
    ViewModel() {

    fun getBooks(): LiveData<List<Book>> = liveData {
        emit(databaseRepository.getSavedBooks())
    }

    fun removeBook(book: Book) {
        databaseRepository.removeBook(book)
    }

}