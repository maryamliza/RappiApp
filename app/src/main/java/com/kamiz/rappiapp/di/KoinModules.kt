package com.kamiz.rappiapp.di

import com.kamiz.rappiapp.data.RappiRepository
import com.kamiz.rappiapp.data.remote.RemoteDataSource
import com.kamiz.rappiapp.data.remote.retrofit.RetrofitManager
import com.kamiz.rappiapp.data.remote.retrofit.ServiceAPI
import com.kamiz.rappiapp.ui.forgotpassword.ForgotPasswordViewModel
import com.kamiz.rappiapp.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { RappiRepository(get()) }

    single { RemoteDataSource(get()) }
    single<ServiceAPI> { RetrofitManager.getService() }
}

val viewModelsModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { ForgotPasswordViewModel(get()) }
}