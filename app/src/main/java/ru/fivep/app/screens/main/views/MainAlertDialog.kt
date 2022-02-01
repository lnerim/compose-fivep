package ru.fivep.app.screens.main.views

import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*

@Composable
fun MainAlertDialog(showDialog: MutableState<Boolean>) {
    var text by remember { mutableStateOf("Название проекта...") }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Новый проект") },
            icon = { Icons.Default.Edit },
            confirmButton = {
                Button(
                    onClick = { showDialog.value = false }
                ) {
                    Text("Создать")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog.value = false }
                ) {
                    Text("Отмена")
                }
            },
            text = { //
                Text("This is a text on the dialog")
                TextField(value = text, onValueChange = { text = it })
            },
        )
    }
}