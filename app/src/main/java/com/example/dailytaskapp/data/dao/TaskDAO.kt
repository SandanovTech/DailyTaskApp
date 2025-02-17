package com.example.dailytaskapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.dailytaskapp.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {

    @Insert
    suspend fun insertTask(task: TaskEntity): Long

    @Update
    suspend fun updateTask(task: TaskEntity)

    @Query("Select * from tasks where id = :taskId")
    suspend fun openSelectedTask(taskId: String): TaskEntity

    @Query("Select * from tasks")
    fun getTasks(): Flow<List<TaskEntity>>
}