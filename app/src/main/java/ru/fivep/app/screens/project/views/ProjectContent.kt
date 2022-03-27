package ru.fivep.app.screens.project.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.fivep.app.screens.project.ProjectEvent
import ru.fivep.app.screens.project.ProjectViewModel

@ExperimentalMaterial3Api
@Composable
fun SecondContent(
    navController: NavController,
    projVM: ProjectViewModel
) {
    val state = projVM.state.value

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        // Информация
        item {
            Column(Modifier.fillMaxWidth()) {
                val textFieldModifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)

                Text(
                    text = "Паспорт проекта",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 12.dp
                    )
                )

                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = state.title,
                    onValueChange = { projVM.onEvent(ProjectEvent.ChangeTitle(it)) },
                    label = { Text("Название проекта") },
                    isError = state.title.isBlank(),
                    trailingIcon = {
                        if (state.title.isBlank())
                            Icon(Icons.Filled.Error,"error")
                    }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = state.supervisor,
                    onValueChange = { projVM.onEvent(ProjectEvent.ChangeSupervisor(it)) },
                    label = { Text("Руководитель проекта") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = state.discipline,
                    onValueChange = { projVM.onEvent(ProjectEvent.ChangeDiscipline(it)) },
                    label = { Text("Учебная дисциплина") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = state.type,
                    onValueChange = { projVM.onEvent(ProjectEvent.ChangeType(it)) },
                    label = { Text("Тип проекта") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = state.purpose,
                    onValueChange = { projVM.onEvent(ProjectEvent.ChangePurpose(it)) },
                    label = { Text("Цель работы") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = state.question,
                    onValueChange = { projVM.onEvent(ProjectEvent.ChangeQuestion(it)) },
                    label = { Text("Вопрос проекта") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = state.summary,
                    onValueChange = { projVM.onEvent(ProjectEvent.ChangeSummary(it)) },
                    label = { Text("Краткое содержание проекта") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = state.result,
                    onValueChange = { projVM.onEvent(ProjectEvent.ChangeResult(it)) },
                    label = { Text("Результат проекта, продукт") }
                )

                Spacer(modifier = Modifier.size(12.dp))

                Text(
                    text = "Задачи проекта",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 12.dp
                    )
                )
            }
        }

        if (state.tasksList.isEmpty()) {
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    text = "Пусто...",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )
            }
        } else {
            items(state.tasksList) { task ->
                ProjectTaskItem(
                    onClick = {
                        navController.navigate(
                            "create_task?projectId=${task.projectId}&taskId=${task.id}"
                        )
                    },
                    data = task
                )
            }
        }

        item {
            Spacer(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSecondContent() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Column(modifier = Modifier.fillMaxSize()) {
                val textFieldModifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                Text(
                    text = "Паспорт проекта",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 12.dp
                    )
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = "",
                    onValueChange = {},
                    label = { Text("Название проекта") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = "",
                    onValueChange = {},
                    label = { Text("Руководитель проекта") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = "",
                    onValueChange = {},
                    label = { Text("Учебная дисциплина") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = "",
                    onValueChange = {},
                    label = { Text("Тип проекта") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = "",
                    onValueChange = {},
                    label = { Text("Цель работы") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = "",
                    onValueChange = {},
                    label = { Text("Вопрос проекта") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = "",
                    onValueChange = {},
                    label = { Text("Краткое содержание проекта") }
                )
                OutlinedTextField(
                    modifier = textFieldModifier,
                    value = "",
                    onValueChange = {},
                    label = { Text("Результат проекта, продукт") }
                )
                Spacer(modifier = Modifier.size(12.dp))

                Text(
                    text = "Задачи проекта",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 12.dp
                    )
                )
            }
        }
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                text = "Пусто...",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
        }
    }
}