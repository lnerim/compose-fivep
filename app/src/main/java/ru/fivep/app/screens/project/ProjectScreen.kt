package ru.fivep.app.screens.project

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.fivep.app.screens.project.views.SecondContent
import ru.fivep.app.screens.project.views.SecondTopBar

@ExperimentalMaterial3Api
@Composable
@Preview
fun PreviewProjectScreen() {
    val navController = rememberNavController()
    val projectId = 0
    ProjectScreen(navController, projectId)
}

@ExperimentalMaterial3Api
@Composable
fun ProjectScreen(
    navController: NavController,
    projectId: Int? = null
) {
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }
    Scaffold(
        topBar = { SecondTopBar(scrollBehavior) },
        content = { SecondContent() },
        floatingActionButton = {}
    )
}