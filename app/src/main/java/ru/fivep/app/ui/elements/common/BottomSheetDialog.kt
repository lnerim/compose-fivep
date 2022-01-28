package ru.fivep.app.ui.elements.common

import android.content.Intent
import android.util.Log
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.fivep.app.SecondActivity
import ru.fivep.app.model.MainData
import ru.fivep.app.model.MainNameModel

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun BottomSheetDialog(
    textFieldViewModel: MainNameModel,
    modalBottomSheetState: ModalBottomSheetState,
    coroutineScope: CoroutineScope,
    onUpdateProject: (MainData) -> Unit,
) {
    val context = LocalContext.current
    Column {
        Text(
            modifier = Modifier.padding(10.dp),
            fontSize = 24.sp,
            text = "Новый проект"
        )
        CustomTextField(
            placeholder = { Text(text = "Имя проекта") },
            value = textFieldViewModel.name,
            onValueChange = { textFieldViewModel.onNameChange(it) }
        )
        Button(
            modifier = Modifier
                .align(Alignment.End)
                .padding(5.dp),
            onClick = {
                // Создание проекта
                onUpdateProject(MainData(0, "Тест"))

                // TODO: Сделать на навигацию
                val intent = Intent(context, SecondActivity::class.java)
                intent.putExtra("name", textFieldViewModel.name)
                // Удаление текста с поля ввода
                textFieldViewModel.onNameChange("000")
                // Корутина для скрытия "диалога"
                coroutineScope.launch {
                    if (modalBottomSheetState.isVisible) modalBottomSheetState.hide()
                }
                // Запуск Активити
                context.startActivity(intent)
            },
            enabled = textFieldViewModel.name.isNotEmpty()
        ) {
            Text(text = "Создать")
        }
    }
}