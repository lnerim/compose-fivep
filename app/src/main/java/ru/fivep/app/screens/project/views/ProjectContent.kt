package ru.fivep.app.screens.project.views

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
                        if (progress < 1f) progress += 0.1f
                    }
            ) {
                Column(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LinearProgressIndicator(
                            modifier = Modifier.clip(AbsoluteRoundedCornerShape(10.dp))
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
                    Text(text = "Название проекта")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSecondContent() {
    SecondContent()
}