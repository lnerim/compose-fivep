package ru.fivep.app.screens.project.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ProjectDeleteDialog(
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            Button(onClick = onConfirm) {
                Text(text = "Удалить")
            }
        },
        dismissButton = {
            FilledTonalButton(onClick = onDismiss) {
                Text(text = "Отмена")
            }
        },
        icon = {
               Icon(imageVector = Icons.Default.DeleteForever, contentDescription = null)
        },
        title = {
            Text(
                text = "Удаление проекта",
                fontWeight = FontWeight.SemiBold
            )
        },
        text = {
            Text(
                text = "Вы уверенны?\nВосстановить его будет нельзя!",
                fontWeight = FontWeight.Light
            )
        }
    )
}