package ru.fivep.app.screens.main.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MainTopBar() {
    CenterAlignedTopAppBar(
        title = { Text("5П - Мой проект!") },
        navigationIcon = {
            Box(
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(modifier = Modifier,
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Иконка"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* TODO: Информация */ }) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    modifier = Modifier.size(26.dp),
                    contentDescription = "Инфо"
                )
            }
        }
    )
}