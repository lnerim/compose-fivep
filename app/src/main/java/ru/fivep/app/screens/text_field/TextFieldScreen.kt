package ru.fivep.app.screens.text_field

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TextFieldScreen(
    navController: NavController,
    viewModel: TextFieldViewModel = viewModel()
) {
    var text by remember {
        mutableStateOf("")
    }

    Box {
        Column {
            Text("Название проекта..")
            TextField(value = text, onValueChange = { text = it})
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

@Preview(showBackground = true)
@Composable
fun PreviewTFS() {
    val navController = rememberNavController()
    TextFieldScreen(navController)
}