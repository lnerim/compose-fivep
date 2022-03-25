package ru.fivep.app.screens.create_project

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.fivep.app.data.projects.ProjectEntity
import ru.fivep.app.data.projects.use_case.ProjectUseCases
import javax.inject.Inject

@HiltViewModel
class CreateProjectViewModel @Inject constructor(
    private val projectUseCases: ProjectUseCases
) : ViewModel() {
    fun saveProject(text: String) {
        viewModelScope.launch {
            projectUseCases.addProject(
                ProjectEntity(null, text)
            )
        }
    }

}