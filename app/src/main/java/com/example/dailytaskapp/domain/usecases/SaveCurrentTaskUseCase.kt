package com.example.dailytaskapp.domain.usecases

import com.example.dailytaskapp.domain.Repository
import com.example.dailytaskapp.domain.model.Task

class SaveCurrentTaskUseCase(private val repository: Repository) {
    suspend fun saveCurrentTask(task: Task) {
        repository.updateTask(task)
    }
}