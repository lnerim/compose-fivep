package ru.fivep.app.ui.elements.main

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.fivep.app.model.MainData

@Composable
fun MainFAB(
    plug: MutableState<Boolean>,
    onUpdateProject: (MainData) -> Unit
) {
    ExtendedFloatingActionButton(
        text = { Text(text = "Создать") },
        onClick = {
            onUpdateProject(MainData(0, "Test"))
            plug.value = true // TODO: Пытаться изменить на более хороший вариант
        },
        icon = {
            Icon(
                imageVector = Icons.Outlined.Edit,
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .size(32.dp)
            )
        }
    )
}