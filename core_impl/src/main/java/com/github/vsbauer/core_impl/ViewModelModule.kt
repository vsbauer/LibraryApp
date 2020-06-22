package com.github.vsbauer.core_impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.Multibinds

@Module
abstract class ViewModelModule {

    @Multibinds
    abstract fun provideMap(): Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: LibraryViewModelFactory): ViewModelProvider.Factory
}