package com.celisdev.userauthdemo.presentation.signup.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.celisdev.userauthdemo.core.Constants

/**
 * Enlace para navegar a la pantalla de inicio de sesión.
 *
 * Muestra un texto con un botón para redirigir al usuario a la pantalla de inicio de sesión.
 *
 * @param modifier Modificador opcional para aplicar estilos adicionales al composable.
 * @param onClick Función que se llama cuando el usuario hace clic en el enlace para iniciar sesión.
 */

@Composable
fun LoginLink(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = Constants.ACCOUNT_PROMPT,
            style = MaterialTheme.typography.labelSmall,
            color = Color(0xFF2F2E2E),
            fontWeight = FontWeight.SemiBold,
        )
        TextButton(onClick = { onClick() }) {
            Text(
                text = Constants.LOGIN_BUTTON_TEXT,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}