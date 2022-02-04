package ru.fivep.app.screens.main

import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.fivep.app.screens.main.viewModel.MainNameModel
import ru.fivep.app.screens.main.viewModel.MainViewModel
import ru.fivep.app.screens.main.views.MainLazyColumn
import ru.fivep.app.screens.main.views.MainPlug
import ru.fivep.app.screens.main.views.MainTopBar
import ru.fivep.app.ui.elements.common.BottomSheetDialog
import ru.fivep.app.screens.main.views.MainFAB

@ExperimentalMaterial3Api
@ExperimentalMaterialApi
@Preview
@Composable
fun PreviewMainScreen() {
    val navController = rememberNavController()
    MainScreen(
        navController = navController,
    )
}

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = viewModel(),
    textFieldViewModel: MainNameModel = viewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    // "Клавиатура"
    val focusRequester = remember { FocusRequester() }
    val localFocusManager = LocalFocusManager.current

    // Скрытие, когда нажатие происходит вне поля BottomSheet
    if (modalBottomSheetState.currentValue != ModalBottomSheetValue.Hidden) {
        DisposableEffect(Unit) {
            onDispose {
                localFocusManager.clearFocus()
            }
        }
    }

    // Экран, поддерживающий BottomSheet
    ModalBottomSheetLayout(
        sheetContent = {
            BottomSheetDialog(
                textFieldViewModel,
                modalBottomSheetState,
                coroutineScope,
                { mainViewModel.updateProject(it) },
                focusRequester,
                localFocusManager
            )
        },
        sheetState = modalBottomSheetState
    ) {
        Scaffold(
            topBar = { MainTopBar() },
            content = {
                if (mainViewModel.isEmptyData) MainLazyColumn(navController, mainViewModel.data)
                else MainPlug()
            },
            floatingActionButton = {
                MainFAB(
                    modalBottomSheetState,
                    coroutineScope,
                    focusRequester,
                    localFocusManager
                )
            }
        )
    }
}