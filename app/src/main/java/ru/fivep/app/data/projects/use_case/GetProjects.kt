package ru.fivep.app.data.projects.use_case

import kotlinx.coroutines.flow.Flow
import ru.fivep.app.data.projects.ProjectEntity
import ru.fivep.app.data.projects.ProjectRepositoryInterface

class GetProjects(
    private val repository: ProjectRepositoryInterface
) {
    operator fun invoke(): Flow<List<ProjectEntity>> =
        repository.getProjects()
}