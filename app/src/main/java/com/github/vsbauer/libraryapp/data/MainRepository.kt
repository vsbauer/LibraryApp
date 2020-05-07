package com.github.vsbauer.libraryapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.github.vsbauer.libraryapp.data.models.Item

object MainRepository {

    fun getBooks(search: String): LiveData<List<Item>> = liveData {
        try {
            emit(BookApiService.newInstance().getBooks(search).items)
        } catch (e: Exception) {
            Log.e("!!!MainRepository", e.toString())
        }
    }

}