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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun PreviewCustomTextField() {
    val (value, setValue) = remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    CustomTextField(
        placeholder = { Text(text = "Введите текст") },
        value = value,
        onValueChange = setValue,
        focusRequester = focusRequester
    )
}

@Composable
fun CustomTextField(
    placeholder: @Composable (() -> Unit)? = null,
    value: String,
    onValueChange: (String) -> Unit,
    focusRequester: FocusRequester
) {

    TextField(
        modifier = Modifier
            .focusRequester(focusRequester)
            .fillMaxWidth(),
        value = value,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.LightGray,
            cursorColor = Color.DarkGray,
            disabledLabelColor = Color.Blue, // При отключении, может и не понадобится
            focusedIndicatorColor = Color.Transparent, // При активном вводе
            unfocusedIndicatorColor = Color.Transparent // При статичном состоянии
        ),
//        label = { Text("123") },
        placeholder = placeholder,
        onValueChange = { onValueChange(it) },
        shape = RoundedCornerShape(0),
        singleLine = true,
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(onClick = { onValueChange("") } ) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = null
                    )
                }
            }
        }
    )
}