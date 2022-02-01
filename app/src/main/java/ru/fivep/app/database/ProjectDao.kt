package ru.fivep.app.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProjectDao {

    @Insert
    fun addProject(project: Project)

    @Delete
    fun deleteProject(project: Project)

    // Все проекты
    @Query("SELECT * FROM projects ORDER BY id ASC")
    fun readProject(): List<Project>

    // Проект по id
    @Query("SELECT * FROM projects WHERE id LIKE :uid")
    fun getProject(uid: Int): Project
}