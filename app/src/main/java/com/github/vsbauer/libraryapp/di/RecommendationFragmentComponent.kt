package com.github.vsbauer.libraryapp.di

import com.github.vsbauer.libraryapp.ui.recommendation.RecommendationFragment
import dagger.Component

@RecommendationFragmentScope
@Component(
    dependencies = [AppComponent::class],
    modules = [RecommendationFragmentModule::class]
)
interface RecommendationFragmentComponent {

    fun inject(fragment: RecommendationFragment)
}