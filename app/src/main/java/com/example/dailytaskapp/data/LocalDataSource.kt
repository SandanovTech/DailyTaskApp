package com.example.dailytaskapp.data

import com.example.dailytaskapp.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun openSelectedTask(id: String): TaskEntity
    fun getCachedTasks(): Flow<List<TaskEntity>>
    suspend fun createTask(task: TaskEntity): TaskEntity
    suspend fun updateTask(task: TaskEntity)
}
