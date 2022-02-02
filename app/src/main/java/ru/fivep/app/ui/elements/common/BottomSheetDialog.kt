package ru.fivep.app.ui.elements.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.fivep.app.screens.main.viewModel.MainData
import ru.fivep.app.screens.main.viewModel.MainNameModel

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun BottomSheetDialog(
    textFieldViewModel: MainNameModel,
    modalBottomSheetState: ModalBottomSheetState,
    coroutineScope: CoroutineScope,
    onUpdateProject: (MainData) -> Unit,
    focusRequester: FocusRequester,
    localFocusManager: FocusManager
) {
    Column {
        Text(
            modifier = Modifier.padding(10.dp),
            fontSize = 24.sp,
            text = "Новый проект"
        )
        CustomTextField(
            placeholder = { Text(text = "Имя проекта") },
            value = textFieldViewModel.name,
            onValueChange = { textFieldViewModel.onNameChange(it) },
            focusRequester = focusRequester
        )
        Button(
            modifier = Modifier
                .align(Alignment.End)
                .padding(5.dp),
            onClick = {
                // Создание проекта
                onUpdateProject(MainData(0, "Тест"))

                // TODO: Сделать на навигацию
                // Удаление текста с поля ввода
                textFieldViewModel.onNameChange("")
                // Корутина для скрытия "диалога"
                coroutineScope.launch {
                    if (modalBottomSheetState.isVisible) {
                        localFocusManager.clearFocus()
                        modalBottomSheetState.hide()
                    }
                }
                // TODO?: Запуск другого экрана???
            },
            enabled = textFieldViewModel.name.isNotEmpty()
        ) {
            Text(text = "Создать")
        }
    }
}