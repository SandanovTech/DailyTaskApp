package com.example.dailytaskapp.data

import com.example.dailytaskapp.data.model.TaskEntity

interface LocalDataSource {
    suspend fun getCachedTask(): TaskEntity
    suspend fun openSelectedTask(id: String) : TaskEntity
    suspend fun getCachedTasks(): List<TaskEntity>
    suspend fun createTask(task : TaskEntity): TaskEntity
}
