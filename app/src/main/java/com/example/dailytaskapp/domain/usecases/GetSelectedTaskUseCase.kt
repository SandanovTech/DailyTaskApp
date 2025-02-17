package com.example.dailytaskapp.domain.usecases

import com.example.dailytaskapp.domain.Repository
import com.example.dailytaskapp.domain.model.Task

class GetSelectedTaskUseCase(private val repository: Repository) {
    suspend fun execute(taskId: String) : Task {
        return repository.openSelectedTask(taskId)
    }
}