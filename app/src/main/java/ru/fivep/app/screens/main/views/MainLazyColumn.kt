package ru.fivep.app.screens.main.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.fivep.app.data.projects.ProjectEntity

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun MainLazyColumn(
    navController: NavController,
    dataList: List<ProjectEntity>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = "Список проектов",
                modifier = Modifier.padding(
                    vertical = 4.dp,
                    horizontal = 16.dp
                )
            )
        }

        items(dataList) { dataList ->
            MainItem(navController = navController, data = dataList)
        }

        item {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
            )
        }
    }
}
//
//@ExperimentalMaterialApi
//@ExperimentalMaterial3Api
//@Preview(showBackground = true)
//@Composable
//fun PreviewMainLazyColumn() {
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
////    val myState: LazyListState = rememberLazyListState()
//    MainLazyColumn(dataList = dataList) //, myState = myState)
//}