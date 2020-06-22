package com.github.vsbauer.recommendation.ui.di

import com.github.vsbauer.core_api.AppProvider
import com.github.vsbauer.core_api.FragmentScope
import com.github.vsbauer.core_impl.ViewModelModule
import com.github.vsbauer.recommendation.ui.RecommendationFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [AppProvider::class],
    modules = [RecommendationFragmentModule::class, ViewModelModule::class]
)
interface RecommendationFragmentComponent {

    companion object {

        fun create(appProvider: AppProvider): RecommendationFragmentComponent {
            return DaggerRecommendationFragmentComponent.builder()
                .appProvider(appProvider)
                .build()
        }
    }

    fun inject(fragment: RecommendationFragment)
}