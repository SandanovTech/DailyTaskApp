package com.example.dailytaskapp.domain

import com.example.dailytaskapp.domain.model.Task

interface Repository {
    suspend fun getTask(): Task
    suspend fun openSelectedTask(id: String) : Task
    suspend fun getTasks(): List<Task>
}