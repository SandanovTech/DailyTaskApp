package com.example.dailytaskapp.presentation

import androidx.lifecycle.ViewModel
import com.example.dailytaskapp.domain.model.Task
import com.example.dailytaskapp.domain.usecases.CreateNewTaskUseCase
import org.koin.core.component.KoinComponent
import java.util.UUID

class NewTaskViewModel(
    private val createNewTaskUseCase: CreateNewTaskUseCase,
) : ViewModel(), KoinComponent {
    suspend fun createTask(title: String, description: String, data: String): Task {
        val task = Task(id = UUID.randomUUID().toString(), title = title, description = description, data = data)
        return createNewTaskUseCase.createNewTask(task)
    }
}