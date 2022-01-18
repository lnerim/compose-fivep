package ru.fivep.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import ru.fivep.app.model.MainData
import ru.fivep.app.model.MainViewModel
import ru.fivep.app.ui.elements.main.MainFAB
import ru.fivep.app.ui.elements.main.MainLazyColumn
import ru.fivep.app.ui.elements.main.MainPlug
import ru.fivep.app.ui.elements.main.MainTopBar
import ru.fivep.app.ui.theme.FivePTheme

@ExperimentalMaterialApi
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

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun Main(
    dataList: List<MainData>,
    onUpdateProject: (MainData) -> Unit
) {
    val plug = remember { mutableStateOf(dataList.isNotEmpty()) }

    Scaffold(
        topBar = { MainTopBar() },
        content = { if (plug.value) MainLazyColumn(dataList) else MainPlug() },
        floatingActionButton = { MainFAB(plug, onUpdateProject) }
    )
}

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewMain() {
    val dataList = remember {
        listOf(
            MainData(0, "Test 0"),
            MainData(1, "Test 1"),
            MainData(2, "Test 2"),
            MainData(3, "Test 3"),
            MainData(4, "Test 4"),
            MainData(5, "Test 5"),
        )
    }
    Main(dataList = dataList) {}
}
