package ru.fivep.app.screens.project

import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.fivep.app.screens.project.views.SecondContent
import ru.fivep.app.screens.project.views.SecondTopBar

@ExperimentalMaterial3Api
@Composable
@Preview
fun PreviewProjectScreen() {
    val navController = rememberNavController()
    ProjectScreen(
        navController = navController,
        projectId = 0
    )
}

@ExperimentalMaterial3Api
@Composable
fun ProjectScreen(
    projectViewModel: ProjectViewModel = viewModel(),
    navController: NavController,
    projectId: Int
) {
    val snackbarHostState = remember { SnackbarHostState() }

    val coroutineScope = rememberCoroutineScope()

    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }

    LaunchedEffect(key1 = Unit) {
        projectViewModel.setProjectId(projectId)
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            SecondTopBar(
                scrollBehavior,
                {
                    projectViewModel.onEvent(ProjectEvent.SaveProject)
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Сохранено!")
                    }
                },
                {
                    projectViewModel.onEvent(ProjectEvent.DeleteProject)
                    navController.navigateUp()
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Удалено!")
                    }
                }
            )
                 },
        content = { SecondContent(projectViewModel) },
        floatingActionButton = {}
    )
}