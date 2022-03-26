package ru.fivep.app.data.projects

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ProjectEntity.TABLE_NAME)
data class ProjectEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,

    val supervisor: String? = null,
    val discipline: String? = null,
    val type: String? = null,
    val purpose: String? = null,
    val question: String? = null,
    val summary: String? = null,
    val result: String? = null
) {
    companion object {
        const val TABLE_NAME = "projects"
    }
}

class InvalidProjectException(message: String): Exception(message)
