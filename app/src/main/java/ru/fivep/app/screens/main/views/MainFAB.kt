package ru.fivep.app.screens.main.views

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@ExperimentalMaterialApi
@Composable
fun MainFAB(
    onClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        text = {
            Text(
                text = "Создать проект"
            )
        },
        onClick = onClick,
        icon = {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = null
            )
        }
    )
}