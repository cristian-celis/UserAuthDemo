package com.celisdev.userauthdemo.presentation.components

import androidx.compose.runtime.Composable
import com.celisdev.userauthdemo.core.Constants

/**
 * Sección para ingresar y validar la contraseña.
 *
 * Esta sección incluye un campo de texto para la contraseña y un mensaje de error opcional si los datos ingresados no son válidos.
 * La opción [isNext] controla el comportamiento del campo de texto, indicando si se debe mover al siguiente campo al presionar Enter.
 *
 * @param value Valor actual del campo de texto para la contraseña.
 * @param isError Indica si hay un error en el campo de contraseña, lo que puede afectar la visualización y validación.
 * @param isNext Booleano que indica si se debe mover al siguiente campo de texto cuando se presiona Enter.
 * @param textError Texto del mensaje de error que se muestra cuando el campo de contraseña tiene errores.
 * @param onEmailChange Función que se llama cuando el valor del campo de contraseña cambia, permitiendo actualizar el estado.
 */

@Composable
fun PasswordSection(value: String, isError: Boolean, isNext: Boolean, textError: String, onEmailChange: (String) -> Unit) {
    CustomInputDescription(text = Constants.PASSWORD_TEXT)

    CustomPasswordTextField(value = value, isNext = isNext, isError = isError) {
        onEmailChange(it)
    }

    if (isError)
        ErrorMessage(text = textError)
}