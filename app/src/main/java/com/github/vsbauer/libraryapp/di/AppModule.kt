package com.github.vsbauer.libraryapp.di

import com.github.vsbauer.libraryapp.data.BookApiService
import com.github.vsbauer.libraryapp.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [ViewModelModule::class])
object AppModule {
    private const val API_URL = "https://www.googleapis.com/books/v1/"

    @Reusable
    @Provides
    @JvmStatic
    fun provideBookApiService(): BookApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(BookApiService::class.java)
    }
}