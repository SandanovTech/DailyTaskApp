package com.example.dailytaskapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey var id: String,
    val title: String,
    val description: String,
    val data: String
)