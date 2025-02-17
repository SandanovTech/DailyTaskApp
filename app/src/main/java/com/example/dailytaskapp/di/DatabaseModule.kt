package com.example.dailytaskapp.di

import androidx.room.Room
import com.example.dailytaskapp.data.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "app_database").build()
    }
    single { get<AppDatabase>().taskDao() }
}