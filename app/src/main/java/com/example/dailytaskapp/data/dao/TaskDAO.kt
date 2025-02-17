package com.example.dailytaskapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dailytaskapp.data.model.TaskEntity

@Dao
interface TaskDAO {

    @Insert
    suspend fun insertTask(task: TaskEntity): Long

    @Query("Select * from tasks where id = :taskId")
    suspend fun openSelectedTask(taskId: String): TaskEntity
}