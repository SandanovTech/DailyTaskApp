package com.example.dailytaskapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailytaskapp.domain.model.Task
import com.example.dailytaskapp.domain.usecases.CreateNewTaskUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import java.time.LocalDateTime
import java.util.UUID

class NewTaskViewModel(
    private val createNewTaskUseCase: CreateNewTaskUseCase,
) : ViewModel(), KoinComponent {
    fun createTask(title: String, description: String, data: LocalDateTime) {
        viewModelScope.launch(Dispatchers.IO) {
            val task = Task(
                id = UUID.randomUUID().toString(),
                title = title,
                description = description,
                data = data
            )
            createNewTaskUseCase.createNewTask(task)
        }
    }
}