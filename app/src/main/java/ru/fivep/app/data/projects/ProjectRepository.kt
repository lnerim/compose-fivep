package ru.fivep.app.data.projects

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProjectRepository @Inject constructor(
    private val projectDao: ProjectDao
) : ProjectRepositoryInterface{

    override fun getProjects(): Flow<List<ProjectEntity>> =
        projectDao.getAllProjects()

    override suspend fun getProjectById(id: Int): ProjectEntity? =
        projectDao.getProjectById(id)

    override suspend fun addProject(item: ProjectEntity) {
        projectDao.addProject(item)
    }

    override suspend fun updateProject(item: ProjectEntity) {
        projectDao.updateProject(item)
    }

    override suspend fun deleteProject(item: ProjectEntity) {
        projectDao.deleteProject(item)
    }
}