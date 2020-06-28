package com.github.vsbauer.search.ui.data

import com.github.vsbauer.search.ui.data.networkDTO.SearchBookResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApiService {

    @GET("volumes")
    suspend fun getBooks(@Query("q") search: String): SearchBookResponse

}
