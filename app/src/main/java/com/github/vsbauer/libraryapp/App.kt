package com.github.vsbauer.libraryapp

import android.app.Application
import com.github.vsbauer.libraryapp.di.app.AppComponent
import com.github.vsbauer.libraryapp.di.app.AppProvider
import com.github.vsbauer.libraryapp.di.app.AppWithAppProvider
import com.github.vsbauer.libraryapp.di.app.DaggerAppComponent


class App : Application(),
    AppWithAppProvider {

    companion object {
        private var appProvider: AppProvider? = null
    }

    override fun onCreate() {
        super.onCreate()
        (getAppProvider() as DaggerAppComponent).inject(this)
    }

    override fun getAppProvider(): AppProvider {
        return appProvider ?: AppComponent.create(this).also {
            appProvider = it
        }
    }

}