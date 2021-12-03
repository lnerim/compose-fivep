package ru.fivep.app.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProjectDao {

    @Insert
    fun addProject(project: Project)

    @Query("SELECT * FROM projects ORDER BY id ASC")
    fun readProject(): LiveData<List<Project>>
}