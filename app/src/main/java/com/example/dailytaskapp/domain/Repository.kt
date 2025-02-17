package com.example.dailytaskapp.domain

import com.example.dailytaskapp.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun openSelectedTask(id: String): Task
    fun getTasks(): Flow<List<Task>>
    suspend fun createTask(task: Task): Task
    suspend fun updateTask(task: Task)
}