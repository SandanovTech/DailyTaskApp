package com.example.dailytaskapp.domain.usecases

import com.example.dailytaskapp.domain.Repository
import com.example.dailytaskapp.domain.model.Task

class CreateNewTaskUseCase(private val repository: Repository) {
    suspend fun createNewTask(task: Task): Task {
        return repository.createTask(task)
    }
}