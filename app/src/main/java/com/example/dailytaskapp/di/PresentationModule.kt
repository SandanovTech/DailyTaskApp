package com.example.dailytaskapp.di

import com.example.dailytaskapp.presentation.MainViewModel
import com.example.dailytaskapp.presentation.TaskViewModel
import org.koin.dsl.module

val presentationModule = module {
    single { TaskViewModel(get(),get(),get()) }
    single { MainViewModel(get()) }
}