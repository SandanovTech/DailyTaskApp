package com.example.dailytaskapp.data.mapper

import com.example.dailytaskapp.data.model.TaskEntity
import com.example.dailytaskapp.domain.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


fun TaskEntity.mapToDomain(): Task {
    return Task(this.id, this.title, this.description, this.data)
}

fun Task.mapToEntity(): TaskEntity {
    return TaskEntity(this.id, this.title, this.description, this.data)
}

fun List<TaskEntity>.mapToDomainList(): List<Task> {
    return this.map { it.mapToDomain() }
}

//fun Flow<List<TaskEntity>>.mapToDomainList(): Flow<List<Task>> {
//    return this.map { it.mapToDomain() }
//}

fun List<Task>.mapToEntityList(): List<TaskEntity> {
    return this.map { it.mapToEntity() }
}