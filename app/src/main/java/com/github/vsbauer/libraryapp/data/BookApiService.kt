package com.github.vsbauer.libraryapp.data

import com.github.vsbauer.libraryapp.data.networkDTO.SearchBookResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApiService {

    @GET("volumes")
    suspend fun getBooks(@Query("q") search: String): SearchBookResponse

    companion object {

        fun newInstance(): BookApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(BookApiService::class.java)
        }
    }
}
