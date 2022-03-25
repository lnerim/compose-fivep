package ru.fivep.app.screens.create_task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.fivep.app.data.tasks.TaskEntity
import ru.fivep.app.data.tasks.use_case.TaskUseCases
import javax.inject.Inject

@HiltViewModel
class CreateTaskViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases
) : ViewModel() {
    fun saveTask(task: String, projectId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            taskUseCases.addTask(
                TaskEntity(
                    id = null,
                    projectId = projectId,
                    task = task
                )
            )
        }
    }
}