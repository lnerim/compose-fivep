package ru.fivep.app.screens.splash

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "FiveP",
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                text = "Привет!",
                textAlign = TextAlign.Center
            )
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        // Любуемся стартовым приветсвием
        delay(1000)
        // запуск основного окна
        navController.navigate("main")
    })
}