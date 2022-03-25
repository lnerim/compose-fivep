package ru.fivep.app.data.tasks.use_case

import ru.fivep.app.data.tasks.InvalidTaskException
import ru.fivep.app.data.tasks.TaskEntity
import ru.fivep.app.data.tasks.TaskRepositoryInterface

class UpdateTask(
    private val repository: TaskRepositoryInterface
) {
    suspend operator fun invoke(item: TaskEntity) {
        if (item.task.isBlank()) {
            throw InvalidTaskException("Название задачи не может быть пустым.")
        }
        repository.updateTask(item)
    }
}