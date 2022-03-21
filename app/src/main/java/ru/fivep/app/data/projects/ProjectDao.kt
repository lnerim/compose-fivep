package ru.fivep.app.data.projects

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {

    @Query("SELECT * FROM ${ProjectEntity.TABLE_NAME}")
    fun getAllProjects(): Flow<List<ProjectEntity>>

    @Query("SELECT * FROM ${ProjectEntity.TABLE_NAME} WHERE id = :id")
    suspend fun getProjectById(id: Int): ProjectEntity?

    @Insert
    suspend fun addProject(item: ProjectEntity)

    @Delete
    suspend fun deleteProject(item: ProjectEntity)
}