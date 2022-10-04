package com.kamiz.rappiapp.di

import org.koin.dsl.module

val repositoryModule = module {
    // Aqui iran las dependencias del repository
}

val viewModelsModule = module {
    // Aqui iran lo viewmodels usando viewModel { SomeViewModel(get())}
}