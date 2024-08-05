package com.celisdev.userauthdemo.presentation.components

import androidx.compose.runtime.Composable
import com.celisdev.userauthdemo.core.Constants

/**
 * Sección para ingresar el correo electrónico.
 *
 * Incluye un campo de texto para el correo electrónico y un mensaje de error si los datos ingresados no son válidos.
 *
 * @param value Valor actual del campo de texto para el correo electrónico.
 * @param isError Indica si hay un error en el campo de correo electrónico.
 * @param onEmailChange Función que se llama cuando el valor del campo de correo electrónico cambia.
 */

@Composable
fun EmailSection(value: String, isError: Boolean, onEmailChange: (String) -> Unit) {
    CustomInputDescription(text = Constants.EMAIL_TEXT)

    CustomEmailTextField(value = value, isError = isError) {
        onEmailChange(it)
    }

    if (isError)
        ErrorMessage(text = Constants.EMAIL_ERROR_TEXT)
}