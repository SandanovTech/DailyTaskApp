package com.example.dailytaskapp.di

import com.example.dailytaskapp.domain.usecases.CreateNewTaskUseCase
import org.koin.dsl.module

val domainModule = module {
    single { CreateNewTaskUseCase(get()) }
}