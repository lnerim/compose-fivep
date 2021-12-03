package ru.fivep.app.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Project::class], version = 1, exportSchema = false)
abstract class ProjectDatabase: RoomDatabase() {
    abstract fun projectDao(): ProjectDao
}
