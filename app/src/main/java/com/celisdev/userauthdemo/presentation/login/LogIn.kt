package com.celisdev.userauthdemo.presentation.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.celisdev.userauthdemo.R
import com.celisdev.userauthdemo.presentation.components.CustomEmailTextField
import com.celisdev.userauthdemo.presentation.components.CustomInputDescription
import com.celisdev.userauthdemo.presentation.components.CustomPasswordTextField
import com.celisdev.userauthdemo.presentation.components.ErrorMessage
import com.celisdev.userauthdemo.presentation.navigation.Routes
import com.celisdev.userauthdemo.ui.theme.MontserratFontFamily
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.log

@Composable
fun LogIn(
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    navController: NavController,
    viewModel: LogInViewModel = hiltViewModel()
) {
    val loginState by viewModel.loginState.collectAsState()
    val rememberMe by viewModel.rememberMe.collectAsState()

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 220.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { focusManager.clearFocus() }
                )
            }
    ) {
        Text(
            text = "Ingreso", style = MaterialTheme.typography.titleLarge
        )
        HorizontalDivider(
            modifier = Modifier
                .width(50.dp)
                .padding(top = 7.dp, bottom = 30.dp), thickness = 1.5.dp, color = Color.Blue
        )

        CustomInputDescription(text = "Correo electrónico")

        CustomEmailTextField(value = loginState.email, isError = loginState.emailError) {
            viewModel.onEmailChange(it)
        }

        if (loginState.emailError)
            ErrorMessage(text = "Correo inválido")

        Spacer(modifier = Modifier.height(20.dp))

        CustomInputDescription(text = "Contraseña")

        CustomPasswordTextField(value = loginState.password, isError = loginState.passwordError) {
            viewModel.onPasswordChange(it)
        }

        if (loginState.passwordError)
            ErrorMessage(text = "Contraseña incorrecta")

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RememberCredentials(checked = rememberMe) {
                viewModel.onRememberMeChange(it)
                scope.launch {
                    snackbarHostState.showSnackbar(if (rememberMe) "Se activó Recordar." else "Se desactivó Recordar.")
                }
            }

            ForgotPassword() {
                scope.launch {
                    snackbarHostState.showSnackbar("Envía a resetear la Contraseña.")
                }
            }
        }
        Spacer(modifier = Modifier.height(27.dp))

        LogInButton {
            viewModel.onLogin()
            scope.launch {
                snackbarHostState.showSnackbar("Se presionó el botón Ingresar.")
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        SignUpLink {
            navController.navigate(route = Routes.SignUp.route)
        }
    }
}

@Composable
private fun LogInButton(
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(
            text = "Ingresar",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.labelLarge,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun RememberCredentials(
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
            text = "Recordarme",
            style = MaterialTheme.typography.labelSmall,
            color = Color(0xFF2F2E2E),
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
private fun ForgotPassword(onClick: () -> Unit) {
    TextButton(onClick = {
        onClick()
    }) {
        Text(
            text = "Contraseña olvidada?", style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun SignUpLink(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Ya tienes una cuenta?",
            style = MaterialTheme.typography.labelSmall,
            color = Color(0xFF2F2E2E),
            fontWeight = FontWeight.SemiBold,
        )
        TextButton(onClick = { onClick() }) {
            Text(
                text = "Registrarse",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}