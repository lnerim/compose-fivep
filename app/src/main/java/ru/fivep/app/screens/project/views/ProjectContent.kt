package ru.fivep.app.screens.project.views

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material.TextField
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.fivep.app.screens.project.ProjectEvent
import ru.fivep.app.screens.project.ProjectViewModel

@Composable
fun SecondContent(
    projVM: ProjectViewModel
) {
    val state = projVM.state.value

    var progress by remember { mutableStateOf(0f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )
    var myColor: Color by remember {
        mutableStateOf(Color.Red)
    }
    myColor = when {
        progress < 0.25f -> { Color.Red }
        progress < 0.75f -> { Color.Yellow }
        else -> { Color.Green }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        // Информация
        item {
            Box(
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (progress < 1f) progress += 0.1f
                        else progress = 0f
                    }
            ) {
                Column(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LinearProgressIndicator(
                            modifier = Modifier
                                .clip(AbsoluteRoundedCornerShape(10.dp))
                                .height(15.dp)
                                .weight(13f)
                                .padding(horizontal = 5.dp),
                            progress = animatedProgress,
                            color = myColor,
                            trackColor = Color.LightGray
                        )
                        Text(
                            modifier = Modifier.weight(5f),
                            text = "100%",
                            fontSize = 40.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    val textFieldModifier = Modifier.fillMaxWidth()
                    // TODO: Тут должны распологаться все элементы
                    TextField(
                        modifier = textFieldModifier,
                        value = state.title,
                        onValueChange = { projVM.onEvent(ProjectEvent.ChangeTitle(it)) },
                        label = { Text("Название проекта") })
                    TextField(
                        modifier = textFieldModifier,
                        value = state.supervisor,
                        onValueChange = { projVM.onEvent(ProjectEvent.ChangeSupervisor(it)) },
                        label = { Text("Руководитель проекта") })
                    TextField(
                        modifier = textFieldModifier,
                        value = state.discipline,
                        onValueChange = { projVM.onEvent(ProjectEvent.ChangeDiscipline(it)) },
                        label = { Text("Учебная дисциплина") })
                    TextField(
                        modifier = textFieldModifier,
                        value = state.type,
                        onValueChange = { projVM.onEvent(ProjectEvent.ChangeType(it)) },
                        label = { Text("Тип проекта") })
                    TextField(
                        modifier = textFieldModifier,
                        value = state.purpose,
                        onValueChange = { projVM.onEvent(ProjectEvent.ChangePurpose(it)) },
                        label = { Text("Цель работы") })
                    TextField(
                        modifier = textFieldModifier,
                        value = state.question,
                        onValueChange = { projVM.onEvent(ProjectEvent.ChangeQuestion(it)) },
                        label = { Text("Вопрос проекта") })
                    TextField(
                        modifier = textFieldModifier,
                        value = state.summary,
                        onValueChange = { projVM.onEvent(ProjectEvent.ChangeSummary(it)) },
                        label = { Text("Краткое содержание проекта") })
                    TextField(
                        modifier = textFieldModifier,
                        value = state.result,
                        onValueChange = { projVM.onEvent(ProjectEvent.ChangeResult(it)) },
                        label = { Text("Результат проекта, продукт") })
                }
            }
        }
        items(state.tasksList) { task ->
            Text(text = "id = ${task.id}, pID = ${task.projectId}, task = ${task.task}")
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewSecondContent() {
//    SecondContent()
//}