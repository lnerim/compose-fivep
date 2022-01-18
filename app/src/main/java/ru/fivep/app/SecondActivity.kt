package ru.fivep.app
// TODO: Обязательно нужна собственная тема,
//  чтобы не заморачиваться сейчас. Если будет время, то сделать адаптивно

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.fivep.app.ui.theme.FivePTheme

@ExperimentalMaterial3Api
@ExperimentalMaterialApi
class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FivePTheme {
                Second()
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
@Preview
fun Second() {
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }
    Scaffold(
        topBar = { SecondTopBar(scrollBehavior) },
        content = { SecondContent() },
        floatingActionButton = {}
    )
}

// TopBar примерного вида TODO: обновить цвета, иконки...
@ExperimentalMaterial3Api
@Composable
fun SecondTopBar(scrollBehavior: TopAppBarScrollBehavior) {
    SmallTopAppBar(
        title = { Text("Мой проект") },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description"
                )
            }
        },
        actions = {
            // RowScope here, so these icons will be placed horizontally
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Localized description"
                )
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Localized description"
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Composable
fun SecondContent() {
    var progress by remember { mutableStateOf(0f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )
    var myColor: Color by remember {
        mutableStateOf(Color.Red)
    }
    myColor = when {
        progress < 0.25f -> { Color.Red }
        progress < 0.75f -> { Color.Yellow }
        else -> { Color.Green }
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        // Информация
        item {
            Box(
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        progress += 0.1f
                    }
            ) {
                Column(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            modifier = Modifier
                                .height(15.dp)
                                .weight(13f)
                                .padding(horizontal = 5.dp)
                        ) {
                            LinearProgressIndicator(
                                modifier = Modifier.fillMaxSize(),
                                progress = animatedProgress,
                                backgroundColor = Color.LightGray,
                                color = myColor
                            )
                        }
                        Text(
                            modifier = Modifier.weight(5f),
                            text = "100%",
                            fontSize = 40.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Text(text = "Название проекта")
                }
            }
        }
    }
}

/* TODO Passport:
    1.  Название проекта
    2.  Руководитель проекта
    3.  Автор проекта (НЕ ОБЯЗАТЕЛЬНО)
    4.  Учебная дисциплина
    5.  Тип проекта
    6.  Цель работы
    7.  Задачи работы
    8.  Вопрос проекта
    9.  Краткое содержание проекта
    10. Результат проекта (продукт)
    */
@Preview
@Composable
fun Passport() {


    /* TODO: Вид таков, что вверху что-то типа Row с карточками, а потом
    *   уже другие типовые данные. Короче разнообразие интерфейса должно
    *   быть, а то не круто получается. */

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
//            .height(430.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ItemTest()
            Divider(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
                color = Color.Magenta)
            ItemTest()
            Divider(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp))
            ItemTest()
            Divider(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp))
            ItemTest()
            Divider(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp))
            ItemTest()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemTest() {
    val lightBlue = Color(0xffd8e6ff)
//    val blue = Color(0xff76a9ff)

    val text = remember { mutableStateOf("") }
//    // Исходное состояние
//    colors = TextFieldDefaults.textFieldColors(
//        backgroundColor = lightBlue,
//        cursorColor = Color.Black,
//        disabledLabelColor = lightBlue,
//        focusedIndicatorColor = Color.Transparent,
//        unfocusedIndicatorColor = Color.Transparent
//    )
//    val myStyle = TextFieldDefaults.textFieldColors(
//        backgroundColor = Color.Green,
//        focusedIndicatorColor = Color.Red, //hide the indicator
//        unfocusedIndicatorColor = Color.Cyan)

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text.value,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Green,
            cursorColor = Color.Black,
            disabledLabelColor = lightBlue, // При отключении, может и не понадобится
            focusedIndicatorColor = Color.Red, // При активном вводе
            unfocusedIndicatorColor = Color.Blue // При статичном состоянии
        ),
//        label = { Text("123") },
        placeholder = { Text(text = "456") },
        onValueChange = { text.value = it },
        shape = RoundedCornerShape(0),
        singleLine = true,
        trailingIcon = {
            if (text.value.isNotEmpty()) {
                IconButton(onClick = { text.value = "" }) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

//@Composable
//fun SecondFAB() {
//    val intSource = remember { MutableInteractionSource() }
//    val pressed = intSource.collectIsPressedAsState()
//
//    ExtendedFloatingActionButton(text = {  }, onClick = {  })
//}