package com.example.dailytaskapp.data.model

import androidx.room.Entity

@Entity(tableName = "tasks")
data class TaskEntity(
    val id: String,
    val title: String,
    val description: String,
    val data: String
)