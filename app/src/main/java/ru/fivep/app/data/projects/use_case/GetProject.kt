package ru.fivep.app.data.projects.use_case

import ru.fivep.app.data.projects.ProjectEntity
import ru.fivep.app.data.projects.ProjectRepositoryInterface

class GetProject(
    private val repository: ProjectRepositoryInterface
) {
    suspend operator fun invoke(id: Int): ProjectEntity? =
        repository.getProjectById(id)
}