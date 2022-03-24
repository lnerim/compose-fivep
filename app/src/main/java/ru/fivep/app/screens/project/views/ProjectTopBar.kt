package ru.fivep.app.screens.project.views

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

// TopBar примерного вида TODO: обновить цвета, иконки...
@ExperimentalMaterial3Api
@Composable
fun SecondTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onSave: () -> Unit,
    onDelete: () -> Unit
) {
    SmallTopAppBar(
        title = { Text("Мой проект") },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description"
                )
            }
        },
        actions = {
            IconButton(onClick = { onDelete() }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Удалить"
                )
            }
            IconButton(onClick = { onSave() }) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Сохранить"
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}