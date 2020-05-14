package com.github.vsbauer.libraryapp.di

import com.github.vsbauer.libraryapp.ui.recommendation.RecommendationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class RecommendationFragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeRecommendationFragmentInjectorFactory(): RecommendationFragment
}