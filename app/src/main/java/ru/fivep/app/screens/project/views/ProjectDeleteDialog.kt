package ru.fivep.app.screens.project.views

import androidx.compose.material.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ProjectDeleteDialog(
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            Button(onClick = { onConfirm() }) {
                Text(text = "Удалить")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text(text = "Отмена")
            }
        },
        title = {
            Text("Удаление проекта")
        },
        text = {
            Text("Вы точно желаете удалить проект?")
        }
    )
}