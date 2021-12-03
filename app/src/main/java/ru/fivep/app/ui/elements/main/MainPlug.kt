package ru.fivep.app.ui.elements.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.fivep.app.R

@Preview
@Composable
fun MainPlug() {
    Box(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .align(Alignment.Center),
            shape = RoundedCornerShape(32.dp),
            elevation = 50.dp
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_addchart_24),
                    contentDescription = null,
                    modifier = Modifier.size(170.dp)
                )
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                Text(
                    text = "У Вас нет ни одного проекта :(\nСамое время создать новый!",
                    fontSize = 16.sp
                )
            }
        }
    }
}


















