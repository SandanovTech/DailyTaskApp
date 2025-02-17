package com.example.dailytaskapp.presentation

import androidx.lifecycle.ViewModel
import com.example.dailytaskapp.domain.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.component.KoinComponent

class MainViewModel : ViewModel(), KoinComponent {

    private val _tasks = MutableStateFlow<MutableList<Task>>(mutableListOf())
    val tasks: MutableStateFlow<MutableList<Task>> = _tasks


}