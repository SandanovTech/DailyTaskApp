package com.example.dailytaskapp.di

import com.example.dailytaskapp.presentation.MainViewModel
import com.example.dailytaskapp.presentation.NewTaskViewModel
import com.example.dailytaskapp.presentation.SelectedTaskViewModel
import org.koin.dsl.module

val presentationModule = module {
    single { NewTaskViewModel(get()) }
    single { MainViewModel(get()) }
    single { SelectedTaskViewModel(get(), get()) }
}