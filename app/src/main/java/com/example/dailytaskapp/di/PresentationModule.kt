package com.example.dailytaskapp.di

import com.example.dailytaskapp.presentation.NewTaskViewModel
import org.koin.dsl.module

val presentationModule = module {
    single { NewTaskViewModel(get()) }
}