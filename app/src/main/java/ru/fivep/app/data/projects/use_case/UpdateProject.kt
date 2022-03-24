package ru.fivep.app.data.projects.use_case

import ru.fivep.app.data.projects.InvalidProjectException
import ru.fivep.app.data.projects.ProjectEntity
import ru.fivep.app.data.projects.ProjectRepositoryInterface

class UpdateProject(
    private val repository: ProjectRepositoryInterface
) {
    suspend operator fun invoke(item: ProjectEntity) {
        if (item.title.isBlank())
            throw InvalidProjectException("Название проекта не должно быть пустым.")
        repository.updateProject(item)
    }
}