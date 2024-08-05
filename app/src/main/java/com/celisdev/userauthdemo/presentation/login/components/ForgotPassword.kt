package com.celisdev.userauthdemo.presentation.login.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.celisdev.userauthdemo.core.Constants

/**
 * Enlace para restablecer la contraseña.
 *
 * Muestra un botón que, cuando se hace clic, llama a la función [onClick] proporcionada para iniciar el proceso de restablecimiento de contraseña.
 *
 * @param onClick Función que se llama cuando el usuario hace clic en el botón para restablecer la contraseña.
 */

@Composable
fun ForgotPassword(onClick: () -> Unit) {
    TextButton(onClick = {
        onClick()
    }) {
        Text(
            text = Constants.FORGOT_PASSWORD, style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold
        )
    }
}