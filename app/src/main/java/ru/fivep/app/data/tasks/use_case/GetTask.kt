package ru.fivep.app.data.tasks.use_case

import ru.fivep.app.data.tasks.TaskEntity
import ru.fivep.app.data.tasks.TaskRepositoryInterface

class GetTask(
    private val repository: TaskRepositoryInterface
) {
    suspend operator fun invoke(id: Int): TaskEntity? =
        repository.getTaskById(id)
}