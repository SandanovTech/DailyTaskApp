package com.example.dailytaskapp.data.mapper

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TaskConverterType {
    private val isoFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun fromLocaleDateTime(value: LocalDateTime): String {
        return value.format(isoFormatter)
    }

    @TypeConverter
    fun toLocalDateTime(value : String) : LocalDateTime {
        return value.let {
            LocalDateTime.parse(it, isoFormatter)
        }
    }
}