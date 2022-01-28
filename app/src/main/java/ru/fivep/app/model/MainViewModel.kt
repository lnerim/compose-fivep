package ru.fivep.app.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var data by mutableStateOf(
        listOf<MainData>()
    )

    var isEmptyData by mutableStateOf(data.isNotEmpty())

    fun updateProject(newData: MainData) {
        data = data + newData
        isEmptyData = data.isNotEmpty()
    }
}