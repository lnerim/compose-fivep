package ru.fivep.app.data.tasks

import kotlinx.coroutines.flow.Flow

interface TaskRepositoryInterface {

    fun getTasks(projectId: Int): Flow<List<TaskEntity>>

    suspend fun getTaskById(id: Int): TaskEntity?

    suspend fun addTask(item: TaskEntity)

    suspend fun updateTask(item: TaskEntity)

    suspend fun deleteTask(item: TaskEntity)
}