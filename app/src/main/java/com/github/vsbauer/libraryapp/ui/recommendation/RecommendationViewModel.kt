package com.github.vsbauer.libraryapp.ui.recommendation

import androidx.lifecycle.ViewModel
import com.github.vsbauer.libraryapp.data.MainRepository

class RecommendationViewModel : ViewModel() {

    fun getBooks(search: String) = MainRepository.getBooks(search)
}
