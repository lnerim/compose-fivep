package ru.fivep.app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.fivep.app.data.projects.ProjectDao
import ru.fivep.app.data.projects.ProjectEntity

@Database(entities = [ProjectEntity::class], version = 1)
abstract class FivePDatabase: RoomDatabase() {
    abstract fun projectDao(): ProjectDao
}