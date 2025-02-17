package com.example.dailytaskapp.data

import com.example.dailytaskapp.data.dao.TaskDAO
import com.example.dailytaskapp.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(private val dao: TaskDAO) : LocalDataSource {

    override suspend fun openSelectedTask(id: String): TaskEntity {
        return dao.openSelectedTask(id)
    }

    override fun getCachedTasks(): Flow<List<TaskEntity>> {
        return dao.getTasks()
    }

    override suspend fun createTask(task: TaskEntity): TaskEntity {
        val taskEntity = dao.insertTask(task)
        task.id = taskEntity.toString()
        return task
    }

    override suspend fun updateTask(task: TaskEntity) {
        return dao.updateTask(task)
    }
}