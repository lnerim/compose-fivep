package ru.fivep.app.screens.project.views

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SecondTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onSave: () -> Unit,
    onDelete: () -> Unit,
    onInfo: () -> Unit = {}
) {
    SmallTopAppBar(
        title = {
            Text(
                text = "Мой проект",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = onInfo) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Инфо"
                )
            }
        },
        actions = {
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Удалить"
                )
            }
            IconButton(onClick = onSave) {
                Icon(
                    imageVector = Icons.Filled.Save,
                    contentDescription = "Сохранить"
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}