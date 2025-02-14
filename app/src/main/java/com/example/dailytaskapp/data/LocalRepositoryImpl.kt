package com.example.dailytaskapp.data

import com.example.dailytaskapp.data.mapper.TaskMapper
import com.example.dailytaskapp.domain.Repository
import com.example.dailytaskapp.domain.model.Task

class LocalRepositoryImpl(
    private val localDataSource: LocalDataSource
) : Repository {
    override suspend fun getTask(): Task {
        return TaskMapper.mapToDomain(localDataSource.getCachedTask())
    }

    override suspend fun openSelectedTask(id: String): Task {
        return TaskMapper.mapToDomain(localDataSource.openSelectedTask(id))
    }

    override suspend fun getTasks(): List<Task> {
        return TaskMapper.mapToDomainList(localDataSource.getCachedTasks())
    }
}
