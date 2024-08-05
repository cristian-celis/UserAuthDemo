package com.celisdev.userauthdemo.presentation.login.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.celisdev.userauthdemo.core.Constants

/**
 * Checkbox para recordar las credenciales del usuario.
 *
 * Permite al usuario seleccionar si desea que sus credenciales se recuerden para futuras sesiones.
 *
 * @param checked Indica si la opción de recordar credenciales está seleccionada.
 * @param onCheckedChange Función que se llama cuando el estado de la checkbox cambia.
 */

@Composable
fun RememberCredentials(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                onCheckedChange(it)
            }
        )
        Text(
            text = Constants.REMEMBER_ME,
            style = MaterialTheme.typography.labelSmall,
            color = Color(0xFF2F2E2E),
            fontWeight = FontWeight.Medium,
        )
    }
}