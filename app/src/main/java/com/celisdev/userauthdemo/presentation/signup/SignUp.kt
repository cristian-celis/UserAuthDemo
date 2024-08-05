package com.celisdev.userauthdemo.presentation.signup

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.celisdev.userauthdemo.core.Constants
import com.celisdev.userauthdemo.presentation.signup.components.ConfirmPasswordSection
import com.celisdev.userauthdemo.presentation.signup.components.CreateAccountButton
import com.celisdev.userauthdemo.presentation.components.EmailSection
import com.celisdev.userauthdemo.presentation.signup.components.LoginLink
import com.celisdev.userauthdemo.presentation.components.PasswordSection
import com.celisdev.userauthdemo.presentation.signup.components.PhoneNumberSection
import com.celisdev.userauthdemo.ui.theme.DividingLine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Registro de Usuario.
 *
 * Permite a los usuarios crear una cuenta proporcionando su correo electrónico, número de teléfono,
 * contraseña y confirmación de contraseña. Incluye validación de campos y muestra mensajes de error según sea necesario.
 *
 * @param modifier Modificador opcional para aplicar estilos adicionales al composable.
 * @param scope Alcance de coroutine utilizado para manejar corutinas.
 * @param snackbarHostState Estado del Snackbar para mostrar mensajes emergentes.
 * @param navigate Función para navegar a otra pantalla.
 * @param viewModel ViewModel que gestiona el estado para el registro de usuario.
 */

@Composable
fun SignUp(
    modifier: Modifier = Modifier,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    navigate: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {

    val signUpState by viewModel.signUpState.collectAsState()

    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { focusManager.clearFocus() }
                )
            }
    ) {
        Text(
            text = Constants.SIGNUP_TITLE_TEXT, style = MaterialTheme.typography.titleLarge
        )
        HorizontalDivider(
            modifier = Modifier
                .width(50.dp)
                .padding(top = 7.dp, bottom = 30.dp), thickness = 1.5.dp, color = DividingLine
        )

        EmailSection(value = signUpState.email, isError = signUpState.emailError) {
            viewModel.onEmailChange(it)
        }
        Spacer(modifier = Modifier.height(20.dp))
        PhoneNumberSection(
            value = signUpState.phoneNumber,
            isError = signUpState.phoneNumberError
        ) {
            viewModel.onPhoneChange(it)
        }
        Spacer(modifier = Modifier.height(20.dp))
        PasswordSection(
            value = signUpState.password,
            isError = signUpState.passwordError,
            isNext = true,
            textError = Constants.WEAK_PASSWORD_ERROR_TEXT
        ) {
            viewModel.onPasswordChange(it)
        }
        Spacer(modifier = Modifier.height(20.dp))
        ConfirmPasswordSection(
            value = signUpState.confirmPassword,
            isError = signUpState.confirmPasswordError
        ) {
            viewModel.onConfirmPasswordChange(it)
        }
        Spacer(modifier = Modifier.height(20.dp))
        CreateAccountButton {
            viewModel.onCreateAccount()
            scope.launch {
                snackbarHostState.showSnackbar(Constants.SNACKBAR_SIGNUP_BUTTON_PRESSED)
            }
        }
        LoginLink {
            navigate()
        }
    }
}