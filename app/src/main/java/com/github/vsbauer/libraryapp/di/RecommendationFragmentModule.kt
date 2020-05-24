package com.github.vsbauer.libraryapp.di

import com.github.vsbauer.libraryapp.data.GoogleBooksRepository
import com.github.vsbauer.libraryapp.data.IGoogleBooksRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable


@Module
abstract class RecommendationFragmentModule {

    @Reusable
    @Binds
    abstract fun bindRepository(repository: GoogleBooksRepository): IGoogleBooksRepository

}