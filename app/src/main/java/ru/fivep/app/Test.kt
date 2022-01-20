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
                CustomTextField(placeholder = { Text(text = "1 текст") })
                CustomTextField(placeholder = { Text(text = "2 текст") })
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

/*
@ExperimentalMaterialApi
@Preview
@Composable
fun HomeScreen1() {
    var text by remember { mutableStateOf("")}
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        topBar = { MainTopBar() },
        floatingActionButton = { FloatingActionButton(onClick = { }) {
            Icon(
                imageVector = Icons.Outlined.Edit,
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .size(32.dp)
            )
        } },
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                TextField(
                    value = text,
                    onValueChange = { text = it }
                )
            }
        }, sheetPeekHeight = 0.dp
    ) {
        Button(onClick = {
            coroutineScope.launch {

                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                    bottomSheetScaffoldState.bottomSheetState.expand()
                } else {
                    bottomSheetScaffoldState.bottomSheetState.collapse()
                }
            }
        }) {
            Text(text = "Expand/Collapse Bottom Sheet")
        }
    }
} */

/*
@ExperimentalMaterial3Api
class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FivePTheme {
                MyNestedScroll()
            }
        }
    }
}

@Composable
fun MyNestedScroll() {
    val toolbarHeight = 48.dp
    val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.roundToPx().toFloat() }
    val toolbarOffsetHeightPx = remember { mutableStateOf(0f) }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = toolbarOffsetHeightPx.value + delta
                toolbarOffsetHeightPx.value = newOffset.coerceIn(-toolbarHeightPx, 0f)
                return Offset.Zero
            }
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {
        // our list with build in nested scroll support that will notify us about its scroll
        LazyColumn(contentPadding = PaddingValues(top = toolbarHeight)) {
            items(100) { index ->
                Text("I'm item $index", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            }
        }
        TopAppBar(
            modifier = Modifier
                .height(toolbarHeight)
                .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) },
            title = { Text("toolbar offset is ${toolbarOffsetHeightPx.value}")
                Log.d("PPPPP", "Value: ${toolbarOffsetHeightPx.value}")}
        )
    }
} */