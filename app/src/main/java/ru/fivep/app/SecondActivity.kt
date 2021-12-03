package ru.fivep.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.fivep.app.ui.elements.project.ProjectNavigationBar
import ru.fivep.app.ui.theme.FivePTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FivePTheme {
                NavBar()
            }
        }
    }
}

@Preview
@Composable
fun NavBar() {
    Scaffold() {

    }
}