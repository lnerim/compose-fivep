package ru.fivep.app.screens.create_project

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel

@ExperimentalMaterial3Api
@Composable
fun CreateProjectScreen(
    navController: NavController,
    viewModel: CreateProjectViewModel = viewModel()
) {
    var text by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {

            CenterAlignedTopAppBar(

                title = {
                    Row {
                        Icon(
                            imageVector = Icons.Default.FolderOpen,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(text = "Проект")
                    }
                },

                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    modifier = Modifier.size(96.dp),
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = null
                )

                Text(
                    modifier = Modifier.padding(6.dp),
                    text = "Рекомендации создания проекта:",
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = " — Название проекта отражает его идею.\n" +
                            "\n" +
                            " — Название проекта должно вызывать у читателя правильные ассоциации, соответствующие по смыслу теме работы.\n" +
                            "\n" +
                            " — Название проекта должно быть коротким. Чем проще звучит название проекта, тем лучше оно воспринимается.",
                    fontWeight = FontWeight.W300
                )

                Spacer(modifier = Modifier)

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    value = text,
                    onValueChange = { text = it },
                    singleLine = true
                )

                Button(
                    onClick = {
                        viewModel.saveProject(text)
                        navController.navigateUp()
                    },
                    enabled = text.isNotBlank()
                ) {
                    Text("Создать")
                }
            }
        }
    }
}