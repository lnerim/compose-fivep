package ru.fivep.app.data.tasks.use_case

import ru.fivep.app.data.tasks.TaskEntity
import ru.fivep.app.data.tasks.TaskRepositoryInterface

class DeleteTask(
    private val repository: TaskRepositoryInterface
) {
    suspend operator fun invoke(item: TaskEntity) {
        repository.deleteTask(item)
    }
}