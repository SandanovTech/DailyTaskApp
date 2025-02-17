package com.example.dailytaskapp.data

import com.example.dailytaskapp.data.dao.TaskDAO
import com.example.dailytaskapp.data.model.TaskEntity

class LocalDataSourceImpl(val dao: TaskDAO) : LocalDataSource {
    override suspend fun getCachedTask(): TaskEntity {
        TODO("Not yet implemented")
    }

    override suspend fun openSelectedTask(id: String): TaskEntity {
        return dao.openSelectedTask(id)
    }

    override suspend fun getCachedTasks(): List<TaskEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun createTask(task: TaskEntity): TaskEntity {
        val taskEntity = dao.insertTask(task)
        task.id = taskEntity.toString()
        return task
    }
}