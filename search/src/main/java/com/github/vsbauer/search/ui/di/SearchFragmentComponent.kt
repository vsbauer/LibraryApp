package com.github.vsbauer.search.ui.di

import com.github.vsbauer.core_api.AppProvider
import com.github.vsbauer.core_api.FragmentScope
import com.github.vsbauer.core_impl.ViewModelModule
import com.github.vsbauer.search.ui.SearchFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [AppProvider::class],
    modules = [SearchFragmentModule::class, ViewModelModule::class]
)
interface SearchFragmentComponent {

    companion object {

        fun create(appProvider: AppProvider): SearchFragmentComponent {
            return DaggerSearchFragmentComponent.builder()
                .appProvider(appProvider)
                .build()
        }
    }

    fun inject(fragment: SearchFragment)
}