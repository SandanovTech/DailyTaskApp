package com.example.dailytaskapp.di

import com.example.dailytaskapp.data.LocalDataSource
import com.example.dailytaskapp.data.LocalDataSourceImpl
import com.example.dailytaskapp.data.repository.LocalRepositoryImpl
import com.example.dailytaskapp.domain.Repository
import org.koin.dsl.module

val dataModule = module {
    single<Repository> { LocalRepositoryImpl(get()) }
    single { LocalDataSourceImpl(get()) }
    single<LocalDataSource> { LocalDataSourceImpl(get()) }

}