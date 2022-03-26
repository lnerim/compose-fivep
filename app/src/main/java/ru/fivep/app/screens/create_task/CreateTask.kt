package ru.fivep.app.screens.create_task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@ExperimentalMaterial3Api
@Composable
fun CreateTask(
    projectId: Int,
    navController: NavController,
    createTaskViewModel: CreateTaskViewModel = viewModel(),
    taskId: Int = -1
) {
    val state = createTaskViewModel.state.value

    LaunchedEffect(key1 = true) {
        createTaskViewModel.setData(projectId, taskId)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Задача") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }
                },
                actions = {
                    if (taskId != -1) {
                        IconButton(
                            onClick = {
                                navController.navigateUp()
                                createTaskViewModel.onEvent(TaskEvent.DeleteTask)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Удалить"
                            )
                        }
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                // TODO padding or arrangement
                modifier = Modifier.fillMaxSize()
            ) {
                OutlinedTextField(
                    value = state.task,
                    onValueChange = { createTaskViewModel.onEvent(TaskEvent.ChangeTask(it)) }
                )
                // TODO Spacer()
                Button(
                    onClick = {
                        navController.navigateUp()
                        createTaskViewModel.onEvent(
                            if (state.id == -1) TaskEvent.AddTask
                            else TaskEvent.UpdateTask
                        )
                    },
                    enabled = state.task.isNotBlank()
                ) {
                    Text( if (state.id == -1) "Создать" else "Обновить" )
                }
            }
        }
    }
}