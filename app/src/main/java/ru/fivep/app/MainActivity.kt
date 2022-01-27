package ru.fivep.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.fivep.app.model.MainData
import ru.fivep.app.model.MainNameModel
import ru.fivep.app.model.MainViewModel
import ru.fivep.app.screens.splash.SplashScreen
import ru.fivep.app.ui.elements.common.BottomSheetDialog
import ru.fivep.app.ui.elements.common.CustomTextField
import ru.fivep.app.ui.elements.main.MainFAB
import ru.fivep.app.ui.elements.main.MainLazyColumn
import ru.fivep.app.ui.elements.main.MainPlug
import ru.fivep.app.ui.elements.main.MainTopBar
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
                        composable("main") { Main(
                            navController = navController,
                            dataList = mainViewModel.data,
                            onUpdateProject = { mainViewModel.updateProject(it) },
                            textFieldViewModel = textFieldViewModel
                        ) }
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun Main(
    navController: NavController,
    dataList: List<MainData>,
    onUpdateProject: (MainData) -> Unit,
    textFieldViewModel: MainNameModel
) {
    val coroutineScope = rememberCoroutineScope()
    val plug = remember { mutableStateOf(dataList.isNotEmpty()) }
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )

    ModalBottomSheetLayout(
        sheetContent = { BottomSheetDialog(textFieldViewModel, modalBottomSheetState, coroutineScope) },
        sheetState = modalBottomSheetState
    ) {
        Scaffold(
            topBar = { MainTopBar() },
            content = { if (plug.value) MainLazyColumn(dataList) else MainPlug() },
            floatingActionButton = {
                MainFAB(plug, modalBottomSheetState, coroutineScope, onUpdateProject)
            }
        )
    }
}

// TODO: Попытаться починить предпросмотр
//@ExperimentalMaterialApi
//@ExperimentalMaterial3Api
//@Preview
//@Composable
//fun PreviewMain() {
//    val testTextFieldViewModel by viewModel<MainNameModel>()
//    val dataList = remember {
//        listOf(
//            MainData(0, "Test 0"),
//            MainData(1, "Test 1"),
//            MainData(2, "Test 2"),
//            MainData(3, "Test 3"),
//            MainData(4, "Test 4"),
//            MainData(5, "Test 5"),
//        )
//    }
//    Main(
//        dataList = dataList,
//        onUpdateProject = {},
//        textFieldViewModel = {}
//    )
//}