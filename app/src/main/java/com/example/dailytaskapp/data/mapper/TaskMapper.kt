package com.example.dailytaskapp.data.mapper

import com.example.dailytaskapp.data.model.TaskEntity
import com.example.dailytaskapp.domain.model.Task


fun TaskEntity.mapToDomain(): Task {
    return Task(this.id, this.title, this.description, this.data)
}

fun Task.mapToEntity(): TaskEntity {
    return TaskEntity(this.id, this.title, this.description, this.data)
}

fun List<TaskEntity>.mapToDomainList(): List<Task> {
    return this.map { it.mapToDomain() }
}

fun List<Task>.mapToEntityList(): List<TaskEntity> {
    return this.map { it.mapToEntity() }
}