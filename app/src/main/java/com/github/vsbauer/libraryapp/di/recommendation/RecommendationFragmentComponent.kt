package com.github.vsbauer.libraryapp.di.recommendation

import com.github.vsbauer.libraryapp.di.app.AppProvider
import com.github.vsbauer.libraryapp.di.viewmodel.ViewModelModule
import com.github.vsbauer.libraryapp.ui.recommendation.RecommendationFragment
import dagger.Component

@RecommendationFragmentScope
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