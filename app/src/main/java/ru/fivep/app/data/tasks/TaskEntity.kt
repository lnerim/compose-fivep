package ru.fivep.app.data.tasks

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception

@Entity(tableName = TaskEntity.TABLE_NAME)
data class TaskEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    val projectId: Int,
    val task: String
) {
    companion object {
        const val TABLE_NAME = "tasks"
    }
}

class InvalidTaskException(message: String): Exception(message)