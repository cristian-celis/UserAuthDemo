package com.celisdev.userauthdemo.presentation.signup.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import com.celisdev.userauthdemo.core.Constants
import com.celisdev.userauthdemo.ui.theme.Background
import com.celisdev.userauthdemo.ui.theme.BackgroundOnError
import com.celisdev.userauthdemo.ui.theme.DividingLine
import com.celisdev.userauthdemo.ui.theme.MontserratFontFamily

@Composable
fun CustomPhoneTextField(value: String, isError: Boolean = false, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        textStyle = MaterialTheme.typography.titleMedium,
        onValueChange = { onValueChange(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = Constants.PHONE_NUMBER_PLACEHOLDER, style = TextStyle(
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
                Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                Spacer(modifier = Modifier.width(7.dp))
                VerticalDivider(
                    modifier = Modifier.height(27.dp),
                    color = DividingLine
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Background,
            unfocusedContainerColor = Background,
            errorContainerColor = BackgroundOnError,
        ),
        isError = isError,
    )
}