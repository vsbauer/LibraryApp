package com.github.vsbauer.libraryapp.di.recommendation

import androidx.lifecycle.ViewModel
import com.github.vsbauer.libraryapp.data.BookApiService
import com.github.vsbauer.libraryapp.data.GoogleBooksRepository
import com.github.vsbauer.libraryapp.data.IGoogleBooksRepository
import com.github.vsbauer.libraryapp.di.viewmodel.ViewModelKey
import com.github.vsbauer.libraryapp.ui.recommendation.RecommendationViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
abstract class RecommendationFragmentModule {
    @Reusable
    @Binds
    abstract fun bindRepository(repository: GoogleBooksRepository): IGoogleBooksRepository

    @Binds
    @IntoMap
    @ViewModelKey(RecommendationViewModel::class)
    abstract fun bindRecommendationViewModel(viewModel: RecommendationViewModel): ViewModel

    @Module
    companion object {
        private const val API_URL = "https://www.googleapis.com/books/v1/"

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


}