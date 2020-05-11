package com.github.vsbauer.libraryapp.ui.recommendation

import androidx.lifecycle.ViewModel
import com.github.vsbauer.libraryapp.data.GoogleBooksRepository

class RecommendationViewModel : ViewModel() {

    fun getBooks(search: String) = GoogleBooksRepository.getBooks(search)
}
