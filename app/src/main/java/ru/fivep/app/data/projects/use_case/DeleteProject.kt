package ru.fivep.app.data.projects.use_case

import ru.fivep.app.data.projects.ProjectEntity
import ru.fivep.app.data.projects.ProjectRepositoryInterface

class DeleteProject(
    private val repository: ProjectRepositoryInterface
) {
    suspend operator fun invoke(item: ProjectEntity) {
        repository.deleteProject(item)
    }
}