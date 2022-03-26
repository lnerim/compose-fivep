package ru.fivep.app.data.tasks

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val tasksDao: TasksDao
) : TaskRepositoryInterface {

    override fun getTasks(projectId: Int): Flow<List<TaskEntity>> =
        tasksDao.getTasksByProject(projectId)

    override suspend fun getTaskById(id: Int): TaskEntity? =
        tasksDao.getTaskById(id)

    override suspend fun addTask(item: TaskEntity) {
        tasksDao.addTask(item)
    }

    override suspend fun updateTask(item: TaskEntity) {
        tasksDao.updateTask(item)
    }

    override suspend fun deleteTask(item: TaskEntity) {
        tasksDao.deleteTask(item)
    }
}