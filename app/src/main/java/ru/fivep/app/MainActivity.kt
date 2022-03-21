package ru.fivep.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.fivep.app.screens.main.MainScreen
import ru.fivep.app.screens.main.MainViewModel
import ru.fivep.app.screens.project.ProjectScreen
import ru.fivep.app.screens.splash.SplashScreen
import ru.fivep.app.screens.text_field.TextFieldScreen
import ru.fivep.app.screens.text_field.TextFieldViewModel
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
                            val textFieldViewModel by viewModels<TextFieldViewModel>()
                            TextFieldScreen(navController, textFieldViewModel)
                        }
                        composable("project/{projectId}") { backStackEntry ->
                            val projectId = backStackEntry.arguments?.getString("projectId")
                            ProjectScreen(navController = navController, projectId?.toInt())
                        }
                    }
                }
            }
        }
    }
}