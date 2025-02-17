package com.example.dailytaskapp.data.repository

import com.example.dailytaskapp.data.LocalDataSource
import com.example.dailytaskapp.data.mapper.mapToDomain
import com.example.dailytaskapp.data.mapper.mapToDomainList
import com.example.dailytaskapp.data.mapper.mapToEntity
import com.example.dailytaskapp.domain.Repository
import com.example.dailytaskapp.domain.model.Task

class LocalRepositoryImpl(
    private val localDataSource: LocalDataSource,
) : Repository {
    override suspend fun getTask(): Task {
        return localDataSource.getCachedTask().mapToDomain()
    }

    override suspend fun openSelectedTask(id: String): Task {
        return localDataSource.openSelectedTask(id).mapToDomain()
    }

    override suspend fun getTasks(): List<Task> {
        return localDataSource.getCachedTasks().mapToDomainList()
    }

    override suspend fun createTask(task: Task): Task {
        return localDataSource.createTask(task.mapToEntity()).mapToDomain()
    }
}
