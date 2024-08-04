package com.celisdev.userauthdemo.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.celisdev.userauthdemo.ui.theme.MontserratFontFamily

@Composable
fun CustomInputDescription(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium
    )
}