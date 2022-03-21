package ru.fivep.app.data.projects.use_case

data class ProjectUseCases(
    val getProjects: GetProjects,
    val getProject: GetProject,
    val addProject: AddProject,
    val deleteProject: DeleteProject
)