package com.celisdev.userauthdemo.presentation.login

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.celisdev.userauthdemo.core.Constants
import com.celisdev.userauthdemo.presentation.components.EmailSection
import com.celisdev.userauthdemo.presentation.components.PasswordSection
import com.celisdev.userauthdemo.presentation.login.components.ForgotPassword
import com.celisdev.userauthdemo.presentation.login.components.LogInButton
import com.celisdev.userauthdemo.presentation.login.components.RememberCredentials
import com.celisdev.userauthdemo.presentation.login.components.SignUpLink
import com.celisdev.userauthdemo.ui.theme.DividingLine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Pantalla de Inicio de Sesión.
 *
 * Esta pantalla permite a los usuarios ingresar sus credenciales (correo electrónico y contraseña) para acceder a la aplicación.
 * También incluye opciones para recordar las credenciales y restablecer la contraseña.
 *
 * @param modifier Modificador opcional para aplicar estilos adicionales al composable.
 * @param scope Alcance de coroutine utilizado para manejar corutinas.
 * @param snackbarHostState Estado del Snackbar para mostrar mensajes emergentes.
 * @param navigate Función que se llama para navegar a la pantalla de registro de usuario.
 * @param viewModel ViewModel que gestiona el estado y la lógica de negocio para el inicio de sesión.
 */

@Composable
fun LogIn(
    modifier: Modifier = Modifier,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    navigate: () -> Unit,
    viewModel: LogInViewModel = hiltViewModel()
) {
    val loginState by viewModel.loginState.collectAsState()
    val rememberMe by viewModel.rememberMe.collectAsState()

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
            text = Constants.LOGIN_TITLE_TEXT, style = MaterialTheme.typography.titleLarge
        )
        HorizontalDivider(
            modifier = Modifier
                .width(50.dp)
                .padding(top = 7.dp, bottom = 30.dp), thickness = 1.5.dp, color = DividingLine
        )

        EmailSection(value = loginState.email, isError = loginState.emailError) {
            viewModel.onEmailChange(it)
        }

        Spacer(modifier = Modifier.height(20.dp))

        PasswordSection(
            value = loginState.password,
            isError = loginState.passwordError,
            isNext = false,
            textError = Constants.PASSWORD_ERROR_TEXT
        ) {
            viewModel.onPasswordChange(it)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RememberCredentials(checked = rememberMe) {
                viewModel.onRememberMeChange(it)
                scope.launch {
                    snackbarHostState.showSnackbar(if (rememberMe) Constants.SNACKBAR_REMEMBER_ACTIVATED else Constants.SNACKBAR_REMEMBER_DEACTIVATED)
                }
            }

            ForgotPassword() {
                scope.launch {
                    snackbarHostState.showSnackbar(Constants.SNACKBAR_RESET_PASSWORD)
                }
            }
        }
        Spacer(modifier = Modifier.height(23.dp))

        LogInButton {
            viewModel.onLogin()
            scope.launch {
                snackbarHostState.showSnackbar(Constants.SNACKBAR_LOGIN_BUTTON_PRESSED)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        SignUpLink {
            navigate()
        }
    }
}