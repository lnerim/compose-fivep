package ru.fivep.app.ui.elements

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalMaterial3Api
@Preview
@Composable
fun Testing() {
    MainToolBar()
}

@ExperimentalMaterial3Api
@Composable
fun MainToolBar() {
    ScrollableState { 0.5f }
}