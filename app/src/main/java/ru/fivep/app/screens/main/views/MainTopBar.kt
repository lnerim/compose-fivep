package ru.fivep.app.screens.main.views

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MainTopBar(
    onInfo: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "5П - Мой проект!",
                fontWeight = FontWeight.Medium,
            )
        },
        actions = {
            IconButton(onClick = onInfo) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    modifier = Modifier.size(32.dp),
                    contentDescription = "Инфо"
                )
            }
        }
    )
}