package ru.fivep.app.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainNameModel: ViewModel() {
    var name by mutableStateOf("")

    fun onNameChange(newName: String) { name = newName }
}