package ru.fivep.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import ru.fivep.app.model.MainData
import ru.fivep.app.model.MainViewModel
import ru.fivep.app.ui.elements.main.MainFAB
import ru.fivep.app.ui.elements.main.MainLazyColumn
import ru.fivep.app.ui.elements.main.MainPlug
import ru.fivep.app.ui.elements.main.MainTopBar
import ru.fivep.app.ui.theme.FivePTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FivePTheme {
                Main(
                    dataList = mainViewModel.data,
                    onUpdateProject = { mainViewModel.updateProject(it) })
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun Main(
    dataList: List<MainData>,
    onUpdateProject: (MainData) -> Unit
) {
    val plug = remember { mutableStateOf(dataList.isNotEmpty()) }
    val myState = rememberLazyListState()
// На данный момент лучший способ отслеживания прокрутки
//    Log.d("FiveP", "Data: ${myState.isScrollInProgress}")
    Log.d("FiveP", "Data: $myState")

    Scaffold(
        topBar = { MainTopBar() },
        content = { if (plug.value) MainLazyColumn(dataList) else MainPlug() },
        floatingActionButton = { MainFAB(plug, onUpdateProject) }
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewMain() {
    val dataList = remember {
        listOf(
            MainData(0, "Test"),
            MainData(1, "Test"),
            MainData(2, "Test"),
            MainData(3, "Test"),
            MainData(4, "Test"),
            MainData(5, "Test"),
        )
    }
    Main(dataList = dataList) {}
}
