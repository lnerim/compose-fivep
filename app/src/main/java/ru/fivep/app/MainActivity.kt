package ru.fivep.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import ru.fivep.app.screens.main.MainScreen
import ru.fivep.app.screens.main.MainViewModel
import ru.fivep.app.screens.project.ProjectScreen
import ru.fivep.app.screens.project.ProjectViewModel
import ru.fivep.app.screens.splash.SplashScreen
import ru.fivep.app.screens.create_project.CreateProjectScreen
import ru.fivep.app.screens.create_project.CreateProjectViewModel
import ru.fivep.app.screens.create_task.CreateTask
import ru.fivep.app.screens.create_task.CreateTaskViewModel
import ru.fivep.app.ui.theme.FivePTheme

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            // Тема приложения
            FivePTheme {
                Surface {
                    // Навигация окон
                    NavHost(navController = navController, startDestination = "splash") {
                        // Непосредственно окна
                        composable("splash") { SplashScreen(navController) }
                        composable("main") {
                            val mainViewModel by viewModels<MainViewModel>()
                            MainScreen(
                                navController = navController,
                                mainViewModel = mainViewModel
                            )
                        }
                        composable("text_field") {
                            val textFieldViewModel by viewModels<CreateProjectViewModel>()
                            CreateProjectScreen(navController, textFieldViewModel)
                        }
                        composable(
                            route = "project?projectId={projectId}",
                            arguments = listOf(
                                navArgument("projectId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            val projectViewModel by viewModels<ProjectViewModel>()
                            ProjectScreen(projectViewModel, navController, it.arguments?.getInt("projectId") ?: -1)
                        }
                        composable(
                            route = "create_task?projectId={projectId}",
                            arguments = listOf(
                                navArgument("projectId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            val projectId = it.arguments?.getInt("projectId") ?: -1
                            val createTaskViewModel by viewModels<CreateTaskViewModel>()
                            CreateTask(projectId, navController, createTaskViewModel)
                        }
                    }
                }
            }
        }
    }
}