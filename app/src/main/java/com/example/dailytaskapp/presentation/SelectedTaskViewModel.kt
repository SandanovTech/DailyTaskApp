package com.example.dailytaskapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailytaskapp.domain.model.Task
import com.example.dailytaskapp.domain.usecases.GetSelectedTaskUseCase
import com.example.dailytaskapp.domain.usecases.SaveCurrentTaskUseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class SelectedTaskViewModel(
    private val getSelectedTaskUseCase: GetSelectedTaskUseCase,
    private val saveCurrentTaskUseCase: SaveCurrentTaskUseCase,
) : ViewModel(), KoinComponent {

    private val _selectedTask = MutableLiveData<Task>()
    val selectedTask: LiveData<Task> = _selectedTask

    fun getSelectedTask(taskId: String) {
        viewModelScope.launch {
            val result = getSelectedTaskUseCase.execute(taskId)
            _selectedTask.value = result
        }
    }

    suspend fun updateCurrentTask(task: Task) {
        saveCurrentTaskUseCase.saveCurrentTask(task)
    }
}