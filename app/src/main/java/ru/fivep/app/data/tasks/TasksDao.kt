package ru.fivep.app.data.tasks

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDao {

    @Query("SELECT * FROM ${TaskEntity.TABLE_NAME} WHERE projectId = :projectId")
    fun getTasksByProject(projectId: Int): Flow<List<TaskEntity>>

    @Query("SELECT * FROM ${TaskEntity.TABLE_NAME} WHERE id = :id")
    fun getTaskById(id: Int): TaskEntity?

    @Insert
    fun addTask(item: TaskEntity)

    @Update
    fun updateTask(item: TaskEntity)

    @Delete
    fun deleteTask(item: TaskEntity)
}