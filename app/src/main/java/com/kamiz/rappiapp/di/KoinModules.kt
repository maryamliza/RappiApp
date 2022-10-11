package com.kamiz.rappiapp.di

import android.content.SharedPreferences
import com.kamiz.rappiapp.data.RappiRepository
import com.kamiz.rappiapp.data.local.sharepreferences.PreferencesManager
import com.kamiz.rappiapp.data.remote.RemoteDataSource
import com.kamiz.rappiapp.data.remote.retrofit.RetrofitManager
import com.kamiz.rappiapp.data.remote.retrofit.ServiceAPI
import com.kamiz.rappiapp.ui.login.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { RappiRepository(get(),get()) }
    single<PreferencesManager>{ PreferencesManager(androidContext()) }

    single { RemoteDataSource(get()) }
    single<ServiceAPI> { RetrofitManager.getService() }
}

val viewModelsModule = module {
    viewModel { LoginViewModel(get()) }
}