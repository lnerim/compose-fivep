package ru.fivep.app.screens.project.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material.icons.filled.Source
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.fivep.app.data.tasks.TaskEntity
import ru.fivep.app.ui.elements.common.MarqueeText

@Composable
fun ProjectTaskItem(
    onClick: () -> Unit,
    data: TaskEntity
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.PushPin,
                contentDescription = "Задача",
                modifier = Modifier
                    .size(24.dp)
            )

            Spacer(modifier = Modifier.size(8.dp))

            Box(
                modifier = Modifier
                    .height(40.dp),
                contentAlignment = Alignment.Center
            ) {
                MarqueeText(
                    text = data.task,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400
                )
            }
        }

        Divider(startIndent = 8.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProjectTaskItem() {
    val data = TaskEntity(
        id = 0,
        projectId = 0,
        task = "Моя Задача"
    )
    ProjectTaskItem(onClick = {}, data = data)
}