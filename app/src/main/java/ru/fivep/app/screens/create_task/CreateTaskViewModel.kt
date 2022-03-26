package ru.fivep.app.screens.create_task

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.fivep.app.data.tasks.TaskEntity
import ru.fivep.app.data.tasks.use_case.*
import javax.inject.Inject

@HiltViewModel
class CreateTaskViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases
) : ViewModel() {

    private val _state = mutableStateOf(TaskState())
    val state: State<TaskState> = _state

    fun setData(newProjectId: Int, taskId: Int) {
        if (taskId == -1) {
            _state.value = state.value.copy(
                projectId = newProjectId,
                id = taskId,
                task = ""
            )
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                taskUseCases.getTask(taskId)?.let { _task ->
                    _state.value = state.value.copy(
                        id = _task.id!!,
                        projectId = _task.projectId,
                        task = _task.task
                    )
                }
            }
        }
    }

    fun onEvent(event: TaskEvent) {
        when (event) {
            is TaskEvent.ChangeTask -> {
                _state.value = state.value.copy(
                    task = event.newValue
                )
            }
            is TaskEvent.AddTask -> {
                viewModelScope.launch(Dispatchers.IO) {
                    taskUseCases.addTask(
                        TaskEntity(
                            id = null,
                            projectId = state.value.projectId,
                            task = state.value.task
                        )
                    )
                }
            }
            is TaskEvent.DeleteTask -> {
                viewModelScope.launch(Dispatchers.IO) {
                    // TODO Поменять!!!
                    val thisTask = taskUseCases.getTask(state.value.id)
                    taskUseCases.deleteTask(thisTask!!)
                }
            }
            is TaskEvent.UpdateTask -> {
                viewModelScope.launch(Dispatchers.IO) {
                    taskUseCases.updateTask(
                        TaskEntity(
                            id = state.value.id,
                            projectId = state.value.projectId,
                            task = state.value.task
                        )
                    )
                }
            }
        }
    }
}

data class TaskState(
    val id: Int = -1,
    val projectId: Int = -1,
    val task: String = ""
)

sealed class TaskEvent {
    data class ChangeTask(val newValue: String): TaskEvent()
    object AddTask: TaskEvent()
    object UpdateTask: TaskEvent()
    object DeleteTask: TaskEvent()
}