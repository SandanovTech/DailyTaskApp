package com.example.dailytaskapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dailytaskapp.domain.model.Task
import com.example.dailytaskapp.domain.usecases.GetTasksUseCase
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent

class MainViewModel(
    private val getTasksUseCase: GetTasksUseCase,
) : ViewModel(), KoinComponent {

    private val _task = MutableLiveData<Task>()
    val task: LiveData<Task> = _task

    fun getTasks(): Flow<List<Task>> {
        return getTasksUseCase.getTasks()
    }

}