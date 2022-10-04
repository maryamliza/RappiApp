package com.kamiz.rappiapp.di

import com.kamiz.rappiapp.data.RappiRepository
import com.kamiz.rappiapp.data.remote.RemoteDataSource
import com.kamiz.rappiapp.data.remote.retrofit.RetrofitManager
import com.kamiz.rappiapp.data.remote.retrofit.ServiceAPI
import org.koin.dsl.module

val repositoryModule = module {
    single { RappiRepository(get()) }

    single { RemoteDataSource(get()) }
    single<ServiceAPI> { RetrofitManager.getService() }
}

val viewModelsModule = module {
}