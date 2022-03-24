package ru.fivep.app.data.projects

import kotlinx.coroutines.flow.Flow

interface ProjectRepositoryInterface {

    fun getProjects(): Flow<List<ProjectEntity>>

    suspend fun getProjectById(id: Int): ProjectEntity?

    suspend fun addProject(item: ProjectEntity)

    suspend fun updateProject(item: ProjectEntity)

    suspend fun deleteProject(item: ProjectEntity)
}