package com.github.vsbauer.libraryapp.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.vsbauer.libraryapp.ui.recommendation.RecommendationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RecommendationViewModel::class)
    abstract fun bindRecommendationViewModel(repoViewModel: RecommendationViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: LibraryViewModelFactory): ViewModelProvider.Factory
}