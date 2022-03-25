package ru.fivep.app.data.tasks.use_case

import kotlinx.coroutines.flow.Flow
import ru.fivep.app.data.tasks.TaskEntity
import ru.fivep.app.data.tasks.TaskRepositoryInterface

class GetTasks(
    private val repository: TaskRepositoryInterface
) {
    operator fun invoke(projectId: Int): Flow<List<TaskEntity>> =
        repository.getTasks(projectId)
}