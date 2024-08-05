package com.celisdev.userauthdemo.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.celisdev.userauthdemo.core.Constants
import com.celisdev.userauthdemo.ui.theme.Background
import com.celisdev.userauthdemo.ui.theme.BackgroundOnError
import com.celisdev.userauthdemo.ui.theme.DividingLine
import com.celisdev.userauthdemo.ui.theme.MontserratFontFamily

/**
 * Campo de texto personalizado para ingresar una contraseña.
 *
 * Este campo de texto está diseñado específicamente para la entrada de contraseñas.
 * Incluye un icono de contraseña, un botón para mostrar u ocultar la contraseña y una línea vertical divisoria.
 * Configura el teclado para la entrada de contraseñas y permite ajustar la visibilidad del texto.
 *
 * @param value El valor actual del campo de texto. Este valor se muestra en el campo y se actualiza
 *              cuando el usuario cambia el texto.
 * @param text Texto del placeholder que se muestra cuando el campo está vacío. Por defecto, se usa
 *             el placeholder definido en `Constants.PASSWORD_PLACEHOLDER`.
 * @param isNext Booleano que indica si el campo debe tener una acción de IME "Next" o "Done". Si es `true`,
 *               el teclado mostrará el botón "Next", de lo contrario, mostrará "Done".
 * @param isError Booleano que indica si el campo debe mostrarse con un estado de error. Si es `true`,
 *                el campo de texto se mostrará con un color de fondo de error.
 * @param onValueChange Función que se llama cuando el valor del campo de texto cambia. Se pasa el nuevo valor
 *                      del campo de texto como argumento.
 */

@Composable
fun CustomPasswordTextField(
    value: String,
    text: String = Constants.PASSWORD_PLACEHOLDER,
    isNext: Boolean = false,
    isError: Boolean = false,
    onValueChange: (String) -> Unit
) {
    var visibility by remember { mutableStateOf(false) }

    TextField(
        value = value,
        textStyle = MaterialTheme.typography.titleMedium,
        onValueChange = { onValueChange(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = text, style = MaterialTheme.typography.titleMedium
            )
        },
        visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = if (isNext) ImeAction.Next else ImeAction.Done
        ),
        leadingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(imageVector = Icons.Default.Password, contentDescription = null)
                Spacer(modifier = Modifier.width(7.dp))
                VerticalDivider(
                    modifier = Modifier.height(27.dp),
                    color = DividingLine
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = { visibility = !visibility }) {
                Icon(
                    imageVector = if (visibility) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = null
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Background,
            unfocusedContainerColor = Background,
            errorContainerColor = BackgroundOnError,
        ),
        isError = isError
    )
}