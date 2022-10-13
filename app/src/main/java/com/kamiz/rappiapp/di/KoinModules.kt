package com.kamiz.rappiapp.di

import com.kamiz.rappiapp.data.RappiRepository
import com.kamiz.rappiapp.data.local.LocalDataSource
import com.kamiz.rappiapp.data.local.preferences.PreferencesManager
import com.kamiz.rappiapp.data.remote.RemoteDataSource
import com.kamiz.rappiapp.data.remote.retrofit.RetrofitManager
import com.kamiz.rappiapp.data.remote.retrofit.ServiceAPI
import com.kamiz.rappiapp.ui.forgotpassword.ForgotPasswordViewModel
import com.kamiz.rappiapp.ui.home.HomeViewModel
import com.kamiz.rappiapp.ui.login.LoginViewModel
import com.kamiz.rappiapp.ui.splash.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { RappiRepository(get(), get()) }

    single { RemoteDataSource(get()) }
    single<ServiceAPI> { RetrofitManager.getService() }

    single { LocalDataSource(get()) }
    single<PreferencesManager> { PreferencesManager(androidContext()) }

}

val viewModelsModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { ForgotPasswordViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { SplashViewModel(get()) }
}