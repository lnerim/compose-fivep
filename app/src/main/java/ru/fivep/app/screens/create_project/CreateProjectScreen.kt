package ru.fivep.app.screens.create_project

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CreateProjectScreen(
    navController: NavController,
    viewModel: CreateProjectViewModel = viewModel()
) {
    var text by remember {
        mutableStateOf("")
    }

    Box {
        Column {
            Text("Название проекта..")
            TextField(value = text, onValueChange = { text = it })
            Button(
                enabled = text.isNotBlank(),
                onClick = {
                    viewModel.saveProject(text)
                    navController.navigateUp()
            }) {
                Text(text = "Создать")
            }
        }
    }
}