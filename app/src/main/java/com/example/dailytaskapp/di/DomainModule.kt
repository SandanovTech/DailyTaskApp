package com.example.dailytaskapp.di

import com.example.dailytaskapp.domain.usecases.CreateNewTaskUseCase
import com.example.dailytaskapp.domain.usecases.GetSelectedTaskUseCase
import com.example.dailytaskapp.domain.usecases.GetTasksUseCase
import com.example.dailytaskapp.domain.usecases.SaveCurrentTaskUseCase
import org.koin.dsl.module

val domainModule = module {
    single { CreateNewTaskUseCase(get()) }
    single { GetTasksUseCase(get()) }
    single { GetSelectedTaskUseCase(get()) }
    single { SaveCurrentTaskUseCase(get()) }
}