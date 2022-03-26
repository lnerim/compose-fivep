package ru.fivep.app.screens.main.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.fivep.app.data.projects.ProjectEntity

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun MainLazyColumn(
    navController: NavController,
    dataList: List<ProjectEntity>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = "Список проектов",
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(
                    vertical = 4.dp,
                    horizontal = 12.dp
                )
            )
        }

        items(dataList) { dataList ->
            MainItem(navController = navController, data = dataList)
        }

        item {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
            )
        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun PreviewMainLazyColumn() {
    val navController = rememberNavController()
    val data = listOf(
        ProjectEntity(1, "Проект 1"),
        ProjectEntity(2, "Проект 2"),
        ProjectEntity(3, "Проект 3"),
        ProjectEntity(4, "Проект 4"),
        ProjectEntity(5, "Проект 5")
    )
    MainLazyColumn(navController, data)
}