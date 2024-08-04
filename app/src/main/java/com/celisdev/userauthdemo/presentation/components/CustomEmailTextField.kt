package com.celisdev.userauthdemo.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.celisdev.userauthdemo.ui.theme.Background
import com.celisdev.userauthdemo.ui.theme.BackgroundOnError
import com.celisdev.userauthdemo.ui.theme.MontserratFontFamily

@Composable
fun CustomEmailTextField(value: String, isError: Boolean = false, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        textStyle = MaterialTheme.typography.titleMedium,
        onValueChange = { onValueChange(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = "Ingresar correo electrónico", style = TextStyle(
                    fontFamily = MontserratFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = (-0.5).sp
                )
            )
        },
        leadingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(imageVector = Icons.Default.Mail, contentDescription = null)
                Spacer(modifier = Modifier.width(7.dp))
                VerticalDivider(
                    modifier = Modifier.height(27.dp),
                    color = Color.Blue
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Background,
            unfocusedContainerColor = Background,
            errorContainerColor = BackgroundOnError,
        ),
        isError = isError,
    )
}