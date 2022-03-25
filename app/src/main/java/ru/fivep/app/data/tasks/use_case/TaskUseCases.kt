package ru.fivep.app.data.tasks.use_case

data class TaskUseCases(
    val getTasks: GetTasks,
    val getTask: GetTask,
    val addTask: AddTask,
    val updateTask: UpdateTask,
    val deleteTask: DeleteTask
)