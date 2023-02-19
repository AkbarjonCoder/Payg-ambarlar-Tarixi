package com.tarix.paygambarlartarixi.room

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel { ViewModel(get()) }
}