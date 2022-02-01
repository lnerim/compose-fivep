package ru.fivep.app.screens.project

import android.util.Log
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import ru.fivep.app.screens.project.views.SecondContent
import ru.fivep.app.screens.project.views.SecondTopBar


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