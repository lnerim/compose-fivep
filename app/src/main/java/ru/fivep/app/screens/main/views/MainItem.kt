package ru.fivep.app.screens.main.views

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.fivep.app.data.projects.ProjectEntity
import ru.fivep.app.ui.elements.common.MarqueeText

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    val data = ProjectEntity(0, "Название проекта...")
    val navController = rememberNavController()
    MainItem(navController, data)
}

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun MainItem(
    navController: NavController,
    data: ProjectEntity
) {
    Card(elevation = 8.dp,
        modifier = Modifier
            .padding(4.dp)
            .clickable {
                // TODO Тут запуск след. экрана
                navController.navigate("project/${data.id}")
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
                MarqueeText(text = data.title)
            }
        }
    }
}