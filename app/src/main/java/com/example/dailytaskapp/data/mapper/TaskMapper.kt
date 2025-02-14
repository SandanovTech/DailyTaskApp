package com.example.dailytaskapp.data.mapper

import com.example.dailytaskapp.data.model.TaskEntity
import com.example.dailytaskapp.domain.model.Task

object TaskMapper {
    fun mapToDomain(entity: TaskEntity): Task {
        return Task(entity.id, entity.title, entity.description, entity.data)
    }

    fun mapToDomainList(entities: List<TaskEntity>): List<Task> {
        return entities.map { mapToDomain(it) }
    }

    fun mapToEntityList(tasks: List<Task>): List<TaskEntity> {
        return tasks.map { mapToEntity(it) }
    }

    fun mapToEntity(task: Task): TaskEntity {
        return TaskEntity(task.id, task.title, task.description, task.data)
    }
}