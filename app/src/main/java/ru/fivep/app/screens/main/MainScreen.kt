package ru.fivep.app.screens.main

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.fivep.app.screens.main.views.MainFAB
import ru.fivep.app.screens.main.views.MainLazyColumn
import ru.fivep.app.screens.main.views.MainPlug
import ru.fivep.app.screens.main.views.MainTopBar

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = viewModel()
) {
    // ViewModel
    val state = mainViewModel.state.value

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { MainTopBar() },
        content = {
            if (state.projectList.isNotEmpty())
                MainLazyColumn(navController, state.projectList)
            else
                MainPlug()
        },
        floatingActionButton = {
            MainFAB { navController.navigate("text_field") }
        }
    )
}

@ExperimentalMaterial3Api
@ExperimentalMaterialApi
@Preview
@Composable
fun PreviewMainScreen() {
    val navController = rememberNavController()
    MainScreen(
        navController = navController,
    )
}
