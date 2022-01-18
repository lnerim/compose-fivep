package ru.fivep.app.ui.elements.main

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.fivep.app.SecondActivity
import ru.fivep.app.TestActivity
import ru.fivep.app.model.MainData
import ru.fivep.app.ui.elements.MarqueeText

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    val data = MainData(0, "Название проекта...")
    MainItem(data = data)
}

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun MainItem(data: MainData) {
    val context = LocalContext.current
    Card(elevation = 8.dp,
        modifier = Modifier.padding(4.dp)
            .clickable {
//                val intent = Intent(context, SecondActivity::class.java)
                val intent = Intent(context, TestActivity::class.java)
                intent.putExtra("id", data.id)
                context.startActivity(intent)
            }
    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "Аккаунт",
                modifier = Modifier
                    .padding(4.dp)
                    .size(38.dp))

            Spacer(modifier = Modifier.padding(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                contentAlignment = Alignment.Center
            ) {
                MarqueeText(text = data.name)
            }
        }
    }
}