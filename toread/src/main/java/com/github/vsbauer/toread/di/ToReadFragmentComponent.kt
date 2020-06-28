package com.github.vsbauer.toread.di

import com.github.vsbauer.core_api.AppProvider
import com.github.vsbauer.core_api.FragmentScope
import com.github.vsbauer.core_impl.ViewModelModule
import com.github.vsbauer.toread.DaggerToReadFragmentComponent
import com.github.vsbauer.toread.ui.ToReadFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [AppProvider::class],
    modules = [ToReadFragmentModule::class, ViewModelModule::class]
)
interface ToReadFragmentComponent {

    companion object {

        fun create(appProvider: AppProvider): ToReadFragmentComponent {
            return DaggerToReadFragmentComponent.builder()
                .appProvider(appProvider)
                .build()
        }
    }

    fun inject(fragment: ToReadFragment)
}