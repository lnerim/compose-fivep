package ru.fivep.app.screens.main.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*

@ExperimentalMaterialApi
@Composable
fun MainFAB(
    modalBottomSheetState: ModalBottomSheetState,
    coroutineScope: CoroutineScope,
    focusRequester: FocusRequester,
    localFocusManager: FocusManager
) {
    ExtendedFloatingActionButton(
        text = { Text(text = "Создать") },
        onClick = {
            // Корутина для появления BottomSheet
            coroutineScope.launch {
                if (modalBottomSheetState.isVisible) {
                    localFocusManager.clearFocus()
                    modalBottomSheetState.hide()
                } else {
                    focusRequester.requestFocus()
                    modalBottomSheetState.show()
                }
            }
        },
        icon = {
            Icon(
                imageVector = Icons.Outlined.Edit,
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .size(32.dp)
            )
        }
    )
}