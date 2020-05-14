package com.github.vsbauer.libraryapp.di

import com.github.vsbauer.libraryapp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [RecommendationFragmentModule::class])
    abstract fun contributeMainActivity(): MainActivity
}