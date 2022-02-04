package ru.fivep.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.fivep.app.screens.main.MainScreen
import ru.fivep.app.screens.main.viewModel.MainNameModel
import ru.fivep.app.screens.main.viewModel.MainViewModel
import ru.fivep.app.screens.project.ProjectScreen
import ru.fivep.app.screens.splash.SplashScreen
import ru.fivep.app.ui.theme.FivePTheme

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
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
                            // Список проектов
                            val mainViewModel by viewModels<MainViewModel>()
                            // Имя проекта для поля ввода
                            val textFieldViewModel by viewModels<MainNameModel>()

                            MainScreen(
                                navController = navController,
                                mainViewModel = mainViewModel,
                                textFieldViewModel = textFieldViewModel
                            )
                        }
                        composable("project/{projectId}") { backStackEntry ->
                            val projectId = backStackEntry.arguments?.getString("projectId")?.toInt()
                            ProjectScreen(navController = navController, projectId)
                        }
                    }
                }
            }
        }
    }
}