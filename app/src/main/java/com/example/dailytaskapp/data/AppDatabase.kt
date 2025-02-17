package com.example.dailytaskapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dailytaskapp.data.dao.TaskDAO
import com.example.dailytaskapp.data.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDAO
}