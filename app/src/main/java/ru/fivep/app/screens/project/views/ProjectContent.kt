package ru.fivep.app.screens.project.views

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondContent() {
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
                        progress += 0.1f
                    }
            ) {
                Column(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            modifier = Modifier
                                .height(15.dp)
                                .weight(13f)
                                .padding(horizontal = 5.dp)
                        ) {
                            LinearProgressIndicator(
                                modifier = Modifier.fillMaxSize(),
                                progress = animatedProgress,
                                backgroundColor = Color.LightGray,
                                color = myColor
                            )
                        }
                        Text(
                            modifier = Modifier.weight(5f),
                            text = "100%",
                            fontSize = 40.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Text(text = "Название проекта")
                }
            }
        }
    }
}

/* TODO Passport:
    1.  Название проекта
    2.  Руководитель проекта
    3.  Автор проекта (НЕ ОБЯЗАТЕЛЬНО)
    4.  Учебная дисциплина
    5.  Тип проекта
    6.  Цель работы
    7.  Задачи работы
    8.  Вопрос проекта
    9.  Краткое содержание проекта
    10. Результат проекта (продукт)
    */