package ru.fivep.app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.fivep.app.data.projects.ProjectDao
import ru.fivep.app.data.projects.ProjectEntity
import ru.fivep.app.data.tasks.TaskEntity
import ru.fivep.app.data.tasks.TasksDao

@Database(
    entities = [
        ProjectEntity::class,
        TaskEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class FivePDatabase: RoomDatabase() {
    abstract fun projectDao(): ProjectDao
    abstract fun taskDao(): TasksDao
}