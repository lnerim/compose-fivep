package ru.fivep.app.screens.main.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.fivep.app.data.projects.ProjectEntity
import ru.fivep.app.ui.elements.common.MarqueeText

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    val data = ProjectEntity(0, "Название проекта...")
    val navController = rememberNavController()
    MainItem(navController, data)
}

@Composable
fun MainItem(
    navController: NavController,
    data: ProjectEntity
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                navController.navigate("project?projectId=${data.id}")
            }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Source,
                contentDescription = "Аккаунт",
                modifier = Modifier
                    .size(42.dp)
            )

            Spacer(modifier = Modifier.size(8.dp))

            Box(
                modifier = Modifier
                    .height(40.dp),
                contentAlignment = Alignment.Center
            ) {
                MarqueeText(
                    text = data.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Divider(startIndent = 8.dp)
    }
}