package com.example.dailytaskapp.domain.model

import java.time.LocalDateTime

data class Task(
    val id: String,
    val title: String,
    val description: String,
    val data: LocalDateTime,
)
