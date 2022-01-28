package ru.fivep.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.fivep.app.model.MainNameModel
import ru.fivep.app.model.MainViewModel
import ru.fivep.app.screens.main.MainScreen
import ru.fivep.app.screens.splash.SplashScreen
import ru.fivep.app.ui.theme.FivePTheme

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel by viewModels<MainViewModel>()      // Список проектов
            val textFieldViewModel by viewModels<MainNameModel>() // Имя проекта для поля ввода
            val navController = rememberNavController()

            // Тема приложения
            FivePTheme {
                Surface {
                    // Навигация окон
                    NavHost(navController = navController, startDestination = "splash") {
                        // Непосредственно окна
                        composable("splash") { SplashScreen(navController) }
                        composable("main") { MainScreen(
                            navController = navController,
                            dataList = mainViewModel.data,
                            onUpdateProject = { mainViewModel.updateProject(it) },
                            isEmptyData = mainViewModel.isEmptyData,
                            textFieldViewModel = textFieldViewModel
                        ) }
                    }
                }
            }
        }
    }
}