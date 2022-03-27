package ru.fivep.app.screens.project

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ru.fivep.app.screens.project.views.PreviewSecondContent
import ru.fivep.app.screens.project.views.ProjectDeleteDialog
import ru.fivep.app.screens.project.views.SecondContent
import ru.fivep.app.screens.project.views.SecondTopBar

@ExperimentalMaterial3Api
@Composable
fun ProjectScreen(
    projectViewModel: ProjectViewModel = viewModel(),
    navController: NavController,
    projectId: Int
) {
    val snackBarHostState = remember { SnackbarHostState() }

    val coroutineScope = rememberCoroutineScope()

    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }

    var dialogVisible by remember { mutableStateOf(false) }
    if (dialogVisible) {
        ProjectDeleteDialog(
            onDismissRequest = { dialogVisible = false },
            onConfirm = {
                dialogVisible = false
                projectViewModel.onEvent(ProjectEvent.DeleteProject)
                navController.navigateUp()
            },
            onDismiss = { dialogVisible = false }
        )
    }

    LaunchedEffect(key1 = Unit) {
        projectViewModel.setProjectId(projectId)
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) },
        topBar = {
            SecondTopBar(
                scrollBehavior,
                {
                    if (projectViewModel.state.value.title.isBlank()) {
                        coroutineScope.launch {
                            snackBarHostState.showSnackbar(
                                message = "Название не может быть пустым",
                                actionLabel = "Понятно"
                            )
                        }
                    } else {
                        projectViewModel.onEvent(ProjectEvent.SaveProject)
                        coroutineScope.launch {
                            snackBarHostState.showSnackbar(
                                message = "Сохранено!",
                                actionLabel = "ОК"
                            )
                        }
                    }
                },
                { dialogVisible = true } // Диалог, чтобы подтвердить удаление
            )
        },
        content = { SecondContent(navController, projectViewModel) },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {
                    Text("Новая задача")
                },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = null
                    )
                },
                onClick = {
                    navController.navigate("create_task?projectId=$projectId")
                }
            )
        }
    )
}

@ExperimentalMaterial3Api
@Composable
@Preview
fun PreviewProjectScreen() {
    val snackBarHostState = remember { SnackbarHostState() }
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) },
        topBar = { SecondTopBar(scrollBehavior, {}, {}) },
        content = { PreviewSecondContent() },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {
                    Text("Новая задача")
                },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = null
                    )
                },
                onClick = {}
            )
        }
    )
}
