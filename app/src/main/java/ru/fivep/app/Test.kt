package ru.fivep.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.fivep.app.ui.elements.common.CustomTextField
import ru.fivep.app.ui.elements.main.MainTopBar
import ru.fivep.app.ui.theme.FivePTheme

@ExperimentalMaterial3Api
@ExperimentalMaterialApi
class TestActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FivePTheme {
                HomeScreen2()
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun HomeScreen2() {
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val coroutineScope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetContent = {
            Column {
//                CustomTextField(placeholder = { Text(text = "1 текст") })
//                CustomTextField(placeholder = { Text(text = "2 текст") })
            }
        },
        sheetState = modalBottomSheetState,
    ) {
        Scaffold(
            topBar = { MainTopBar() },
            floatingActionButton = {
                FloatingActionButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(4.dp)
                            .size(32.dp)
                    )
                }
            }
        ) {
            // Scaffold content
            Button(onClick = {
                coroutineScope.launch {

                    if (modalBottomSheetState.isVisible) {
                        modalBottomSheetState.hide()
                    } else {
                        modalBottomSheetState.show()
                    }
                }
            }) {
                Text(text = "Expand/Collapse Bottom Sheet")
            }
        }
    }
}