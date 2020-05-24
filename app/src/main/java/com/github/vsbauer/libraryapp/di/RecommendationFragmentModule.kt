package com.github.vsbauer.libraryapp.di

import com.github.vsbauer.libraryapp.data.GoogleBooksRepository
import com.github.vsbauer.libraryapp.data.IGoogleBooksRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class RecommendationFragmentModule {

    @Singleton
    @Binds
    abstract fun bindRepository(repository: GoogleBooksRepository): IGoogleBooksRepository

}