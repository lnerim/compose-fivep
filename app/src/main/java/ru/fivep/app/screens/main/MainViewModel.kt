package ru.fivep.app.screens.main

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import ru.fivep.app.data.projects.ProjectEntity
import ru.fivep.app.data.projects.use_case.ProjectUseCases
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val projectUseCases: ProjectUseCases
): ViewModel() {
    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state

    private var getProjectJob: Job? = null

    init {
        getProjects()
        Log.d("PPPPP", "init MainViewModel")
    }

    fun onEvent(event: ProjectEvent) {
        when(event) {
            is ProjectEvent.NewProject -> {}

        }
    }

    private fun getProjects() {
        getProjectJob?.cancel()
        getProjectJob = projectUseCases.getProjects()
            .onEach { projects ->
                _state.value = state.value.copy(
                    projectList = projects
                )

            }
            .launchIn(viewModelScope)
    }
}

data class MainState(
    val projectList: List<ProjectEntity> = emptyList()
)

sealed class ProjectEvent {
    data class NewProject(val value: Int): ProjectEvent()
}