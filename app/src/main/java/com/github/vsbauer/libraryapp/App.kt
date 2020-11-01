package com.github.vsbauer.libraryapp

import android.app.Application
import com.github.vsbauer.core_api.AppProvider
import com.github.vsbauer.core_api.AppWithAppProvider


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