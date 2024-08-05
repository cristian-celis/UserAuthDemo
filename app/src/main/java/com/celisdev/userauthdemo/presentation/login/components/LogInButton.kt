package com.celisdev.userauthdemo.presentation.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.celisdev.userauthdemo.core.Constants

/**
 * Botón para iniciar sesión.
 *
 * Este botón, cuando se hace clic, llama a la función [onClick] proporcionada para manejar la acción de inicio de sesión.
 *
 * @param onClick Función que se llama cuando el usuario hace clic en el botón.
 */

@Composable
fun LogInButton(
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(
            text = Constants.LOGIN_BUTTON_TEXT,
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.labelLarge,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
    }
}