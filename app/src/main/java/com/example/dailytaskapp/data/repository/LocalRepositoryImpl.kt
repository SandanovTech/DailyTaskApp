package com.example.dailytaskapp.data.repository

import com.example.dailytaskapp.data.LocalDataSource
import com.example.dailytaskapp.data.mapper.mapToDomain
import com.example.dailytaskapp.data.mapper.mapToDomainList
import com.example.dailytaskapp.data.mapper.mapToEntity
import com.example.dailytaskapp.domain.Repository
import com.example.dailytaskapp.domain.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalRepositoryImpl(
    private val localDataSource: LocalDataSource,
) : Repository {

    override suspend fun openSelectedTask(id: String): Task {
        return localDataSource.openSelectedTask(id).mapToDomain()
    }

    override fun getTasks(): Flow<List<Task>> {
        return localDataSource.getCachedTasks().map { it.mapToDomainList() }
    }

    override suspend fun createTask(task: Task): Task {
        return localDataSource.createTask(task.mapToEntity()).mapToDomain()
    }

    override suspend fun updateTask(task: Task) {
        return localDataSource.updateTask(task.mapToEntity())
    }
}
