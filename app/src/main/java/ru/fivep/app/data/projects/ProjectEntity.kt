package ru.fivep.app.data.projects

import androidx.room.Entity
import androidx.room.PrimaryKey

/* TODO Passport:
    0.  Идентификатор (id)
    1.  Название проекта (title)
    2.  Руководитель проекта (supervisor)
    3.  Учебная дисциплина (discipline)
    4.  Тип проекта (type)
    5.  Цель работы (purpose)
    6.  Вопрос проекта (question)
    7.  Краткое содержание проекта (summary)
    8. Результат проекта, продукт (result)
    */
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
