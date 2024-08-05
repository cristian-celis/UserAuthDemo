package com.celisdev.userauthdemo.presentation.signup.components

import androidx.compose.runtime.Composable
import com.celisdev.userauthdemo.core.Constants
import com.celisdev.userauthdemo.presentation.components.CustomInputDescription
import com.celisdev.userauthdemo.presentation.components.ErrorMessage

/**
 * Sección para ingresar el número de teléfono.
 *
 * Incluye un campo de texto para el número de teléfono y un mensaje de error si los datos ingresados no son válidos.
 *
 * @param value Valor actual del campo de texto para el número de teléfono.
 * @param isError Indica si hay un error en el campo de número de teléfono.
 * @param onPhoneChange Función que se llama cuando el valor del campo de número de teléfono cambia.
 */

@Composable
fun PhoneNumberSection(value: String, isError: Boolean, onEmailChange: (String) -> Unit) {
    CustomInputDescription(text = Constants.PHONE_NUMBER_TEXT)

    CustomPhoneTextField(value = value, isError = isError) {
        onEmailChange(it)
    }

    if (isError)
        ErrorMessage(text = Constants.PHONE_NUMBER_ERROR_TEXT)
}