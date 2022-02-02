package ru.fivep.app.screens.main

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavController
import ru.fivep.app.screens.main.viewModel.MainData
import ru.fivep.app.screens.main.viewModel.MainNameModel
import ru.fivep.app.screens.main.views.MainLazyColumn
import ru.fivep.app.screens.main.views.MainPlug
import ru.fivep.app.screens.main.views.MainTopBar
import ru.fivep.app.ui.elements.common.BottomSheetDialog
import ru.fivep.app.screens.main.views.MainFAB

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun MainScreen(
    navController: NavController,
    dataList: List<MainData>,
    onUpdateProject: (MainData) -> Unit,
    isEmptyData: Boolean,
    textFieldViewModel: MainNameModel
) {
    val coroutineScope = rememberCoroutineScope()
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    // "Клавиатура"
    val focusRequester = remember { FocusRequester() }
    val localFocusManager = LocalFocusManager.current

    // Экран, поддерживающий BottomSheet
    ModalBottomSheetLayout(
        sheetContent = {
            BottomSheetDialog(
                textFieldViewModel,
                modalBottomSheetState,
                coroutineScope,
                onUpdateProject,
                focusRequester,
                localFocusManager
            )
        },
        sheetState = modalBottomSheetState
    ) {
        Scaffold(
            topBar = { MainTopBar() },
            content = { if (isEmptyData) MainLazyColumn(navController, dataList) else MainPlug() },
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