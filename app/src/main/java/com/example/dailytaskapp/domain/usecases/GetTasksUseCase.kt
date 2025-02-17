package com.example.dailytaskapp.domain.usecases

import com.example.dailytaskapp.domain.Repository
import com.example.dailytaskapp.domain.model.Task
import kotlinx.coroutines.flow.Flow

class GetTasksUseCase(private val repository: Repository) {
    fun getTasks(): Flow<List<Task>> {
        return repository.getTasks()
    }
}