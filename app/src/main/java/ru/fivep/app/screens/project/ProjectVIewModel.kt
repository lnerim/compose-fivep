package ru.fivep.app.screens.project

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.fivep.app.data.projects.ProjectEntity
import ru.fivep.app.data.projects.use_case.ProjectUseCases
import ru.fivep.app.data.tasks.use_case.TaskUseCases
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor(
    private val projectUseCases: ProjectUseCases,
    private val taskUseCases: TaskUseCases
): ViewModel() {

    private val _state = mutableStateOf(ProjectState())
    val state: State<ProjectState> = _state

    fun setProjectId(projectId: Int) {
        viewModelScope.launch {
            projectUseCases.getProject(projectId)?.let { project ->
                Log.d("PPPPP", "get project")
                _state.value = state.value.copy(
                    id = project.id,
                    title = project.title,
                    supervisor = project.supervisor.orEmpty(),
                    discipline = project.discipline.orEmpty(),
                    type = project.type.orEmpty(),
                    purpose = project.purpose.orEmpty(),
                    question = project.question.orEmpty(),
                    summary = project.summary.orEmpty(),
                    result = project.result.orEmpty()
                )
            }
        }
    }

//    init {
//        Log.d("PPPPP", "init project VM")
//        savedStateHandle.get<Int>("projectId")?.let { projectId ->
//            Log.d("PPPPP", "projectId: $projectId")
//            viewModelScope.launch {
//                projectUseCases.getProject(projectId)?.let { project ->
//                    Log.d("PPPPP", "get project")
//                    _state.value = state.value.copy(
//                        id = project.id,
//                        title = project.title,
//                        supervisor = project.supervisor.orEmpty(),
//                        discipline = project.discipline.orEmpty(),
//                        type = project.type.orEmpty(),
//                        purpose = project.purpose.orEmpty(),
//                        question = project.question.orEmpty(),
//                        summary = project.summary.orEmpty(),
//                        result = project.result.orEmpty()
//                    )
//                }
//            }
//        }
//    }

    fun onEvent(event: ProjectEvent) {
        when (event) {
            is ProjectEvent.ChangeTitle -> {
                _state.value = state.value.copy(
                    title = event.newValue
                )
            }
            is ProjectEvent.ChangeSupervisor -> {
                _state.value = state.value.copy(
                    supervisor = event.newValue
                )
            }
            is ProjectEvent.ChangeDiscipline -> {
                _state.value = state.value.copy(
                    discipline = event.newValue
                )
            }
            is ProjectEvent.ChangeType -> {
                _state.value = state.value.copy(
                    type = event.newValue
                )
            }
            is ProjectEvent.ChangePurpose -> {
                _state.value = state.value.copy(
                    purpose = event.newValue
                )
            }
            is ProjectEvent.ChangeQuestion -> {
                _state.value = state.value.copy(
                    question = event.newValue
                )
            }
            is ProjectEvent.ChangeSummary -> {
                _state.value = state.value.copy(
                    summary = event.newValue
                )
            }
            is ProjectEvent.ChangeResult -> {
                _state.value = state.value.copy(
                    result = event.newValue
                )
            }
            is ProjectEvent.SaveProject -> {
                viewModelScope.launch {
                    projectUseCases.updateProject(
                        ProjectEntity(
                            id = state.value.id,
                            title = state.value.title,
                            supervisor = state.value.supervisor,
                            discipline = state.value.discipline,
                            type = state.value.type,
                            purpose = state.value.purpose,
                            question = state.value.question,
                            summary = state.value.summary,
                            result = state.value.result
                        )
                    )
                }
            }
            is ProjectEvent.DeleteProject -> {
                viewModelScope.launch {
                    // TODO: Поменять!!!
                    val thisProject = projectUseCases.getProject(state.value.id!!)
                    projectUseCases.deleteProject(thisProject!!)
                }
            }
        }
    }
}

data class ProjectState(
    val id: Int? = -1,
    val title: String = "",
    val supervisor: String = "",
    val discipline: String = "",
    val type: String = "",
    val purpose: String = "",
    val question: String = "",
    val summary: String = "",
    val result: String = ""
)

sealed class ProjectEvent {
    data class ChangeTitle(val newValue: String): ProjectEvent()
    data class ChangeSupervisor(val newValue: String): ProjectEvent()
    data class ChangeDiscipline(val newValue: String): ProjectEvent()
    data class ChangeType(val newValue: String): ProjectEvent()
    data class ChangePurpose(val newValue: String): ProjectEvent()
    data class ChangeQuestion(val newValue: String): ProjectEvent()
    data class ChangeSummary(val newValue: String): ProjectEvent()
    data class ChangeResult(val newValue: String): ProjectEvent()
    object SaveProject: ProjectEvent()
    object DeleteProject: ProjectEvent()
}