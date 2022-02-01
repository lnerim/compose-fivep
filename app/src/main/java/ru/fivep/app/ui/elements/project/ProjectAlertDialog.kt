package ru.fivep.app.ui.elements.project

import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun ProjectAlertDialog(showDialog: MutableState<Boolean>) {
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Новый проект") },
            icon = { Icons.Default.Edit },
            confirmButton = {
                Button(
                    onClick = { showDialog.value = false }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog.value = false }
                ) {
                    Text("Dismiss")
                }
            },
            text = {
                Text("This is a text on the dialog")
                TextField(value = "123456789", onValueChange = {})
            },
        )
    }
}