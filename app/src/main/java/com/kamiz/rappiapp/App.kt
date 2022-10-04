package com.kamiz.rappiapp

import android.app.Application
import com.kamiz.rappiapp.di.repositoryModule
import com.kamiz.rappiapp.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(repositoryModule, viewModelsModule))
        }
    }
}