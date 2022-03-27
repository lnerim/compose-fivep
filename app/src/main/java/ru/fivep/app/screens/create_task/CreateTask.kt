package ru.fivep.app.screens.create_task

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

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

                title = {
                    Row {
                        Icon(
                            imageVector = Icons.Default.WorkOutline,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(text = "Задача")
                    }
                },

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
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    modifier = Modifier.size(96.dp),
                    imageVector = Icons.Default.Timeline,
                    contentDescription = null
                )

                Text(
                    modifier = Modifier.padding(6.dp),
                    text = "Рекомендации создания задач проекта:",
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = " - Задачи проектной работы формируются после постановки цели и описывают, " +
                            "что конкретно необходимо будет сделать для её достижения.",
                    fontWeight = FontWeight.W300,
                    textAlign = TextAlign.Justify
                )

                Spacer(modifier = Modifier)

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    value = state.task,
                    onValueChange = { createTaskViewModel.onEvent(TaskEvent.ChangeTask(it)) }
                )

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