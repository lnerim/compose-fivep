package ru.fivep.app.data.projects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ProjectEntity.TABLE_NAME)
data class ProjectEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo
    val title: String
) {
    companion object {
        const val TABLE_NAME = "projects"
    }
}

class InvalidProjectException(message: String): Exception(message)
