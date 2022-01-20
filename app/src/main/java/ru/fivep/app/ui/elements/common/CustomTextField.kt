package ru.fivep.app.ui.elements.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun PreviewCustomTextField() {
    CustomTextField(placeholder = { Text(text = "Введите текст") })
}

@Composable
fun CustomTextField(
    placeholder: @Composable (() -> Unit)? = null
) {
    val text = remember { mutableStateOf("") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text.value,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.LightGray,
            cursorColor = Color.DarkGray,
            disabledLabelColor = Color.Blue, // При отключении, может и не понадобится
            focusedIndicatorColor = Color.Transparent, // При активном вводе
            unfocusedIndicatorColor = Color.Transparent // При статичном состоянии
        ),
//        label = { Text("123") },
        placeholder = placeholder,
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