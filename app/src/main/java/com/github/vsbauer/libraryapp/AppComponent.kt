package com.github.vsbauer.libraryapp

import android.app.Application
import android.content.Context
import com.github.vsbauer.core_api.AppProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : AppProvider {

    companion object {
        private var appComponent: AppProvider? = null
        fun create(application: Application): AppProvider {
            return appComponent
                ?: DaggerAppComponent.builder()
                    .application(application)
                    .build().also {
                        appComponent = it
                    }
        }
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)

}

