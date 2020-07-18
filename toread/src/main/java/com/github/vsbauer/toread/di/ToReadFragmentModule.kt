package com.github.vsbauer.toread.di

import androidx.lifecycle.ViewModel
import com.github.vsbauer.core_api.ViewModelKey
import com.github.vsbauer.toread.ui.ToReadViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ToReadFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(ToReadViewModel::class)
    abstract fun bindToReadViewModel(viewModel: ToReadViewModel): ViewModel


}