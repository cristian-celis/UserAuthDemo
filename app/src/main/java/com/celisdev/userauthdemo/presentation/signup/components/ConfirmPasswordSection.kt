package com.celisdev.userauthdemo.presentation.signup.components

import androidx.compose.runtime.Composable
import com.celisdev.userauthdemo.core.Constants
import com.celisdev.userauthdemo.presentation.components.CustomInputDescription
import com.celisdev.userauthdemo.presentation.components.CustomPasswordTextField
import com.celisdev.userauthdemo.presentation.components.ErrorMessage

/**
 * Sección para confirmar la contraseña.
 *
 * Incluye un campo de texto para la confirmación de la contraseña y un mensaje de error si los datos ingresados no son válidos.
 *
 * @param value Valor actual del campo de texto para la confirmación de la contraseña.
 * @param isError Indica si hay un error en el campo de confirmación de contraseña.
 * @param onConfirmPasswordChange Función que se llama cuando el valor del campo de confirmación de contraseña cambia.
 */

@Composable
fun ConfirmPasswordSection(value: String, isError: Boolean, onEmailChange: (String) -> Unit) {
    CustomInputDescription(text = Constants.CONFIRM_PASSWORD_TEXT)

    CustomPasswordTextField(value = value, text = Constants.REENTER_PASSWORD_PLACEHOLDER, isError = isError) {
        onEmailChange(it)
    }

    if (isError)
        ErrorMessage(text = Constants.CONFIRM_PASSWORD_ERROR_TEXT)
}