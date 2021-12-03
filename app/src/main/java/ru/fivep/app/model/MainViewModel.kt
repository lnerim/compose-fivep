package ru.fivep.app.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var data by mutableStateOf(
        listOf<MainData>()
    )

    fun updateProject(newData: MainData) {
        data = data + newData
    }

    fun dataNotEmpty() = data.isNotEmpty()
}