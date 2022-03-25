package ru.fivep.app.data.tasks.use_case

import ru.fivep.app.data.tasks.InvalidTaskException
import ru.fivep.app.data.tasks.TaskEntity
import ru.fivep.app.data.tasks.TaskRepositoryInterface

class AddTask(
    private val repository: TaskRepositoryInterface
) {
    @Throws(InvalidTaskException::class)
    suspend operator fun invoke(item: TaskEntity) {
        if (item.task.isBlank()) {
            throw InvalidTaskException("Имя задачи не может быть пустым.")
        }
        repository.addTask(item)
    }
}