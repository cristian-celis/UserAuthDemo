package com.celisdev.userauthdemo.presentation.signup

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.navigation.NavController
import com.celisdev.userauthdemo.core.Constants
import com.celisdev.userauthdemo.presentation.components.CustomEmailTextField
import com.celisdev.userauthdemo.presentation.components.CustomInputDescription
import com.celisdev.userauthdemo.presentation.components.CustomPasswordTextField
import com.celisdev.userauthdemo.presentation.components.ErrorMessage
import com.celisdev.userauthdemo.presentation.navigation.Routes
import com.celisdev.userauthdemo.presentation.signup.components.CustomPhoneTextField
import com.celisdev.userauthdemo.ui.theme.DividingLine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SignUp(
    modifier: Modifier = Modifier,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    navController: NavController,
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
        PasswordSection(value = signUpState.password, isError = signUpState.passwordError) {
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
            navController.navigate(route = Routes.LogIn.route)
        }
    }
}

@Composable
private fun EmailSection(value: String, isError: Boolean, onEmailChange: (String) -> Unit) {
    CustomInputDescription(text = Constants.EMAIL_TEXT)

    CustomEmailTextField(value = value, isError = isError) {
        onEmailChange(it)
    }

    if (isError)
        ErrorMessage(text = Constants.EMAIL_ERROR_TEXT)
}

@Composable
private fun PhoneNumberSection(value: String, isError: Boolean, onEmailChange: (String) -> Unit) {
    CustomInputDescription(text = Constants.PHONE_NUMBER_TEXT)

    CustomPhoneTextField(value = value, isError = isError) {
        onEmailChange(it)
    }

    if (isError)
        ErrorMessage(text = Constants.PHONE_NUMBER_ERROR_TEXT)
}

@Composable
private fun PasswordSection(value: String, isError: Boolean, onEmailChange: (String) -> Unit) {
    CustomInputDescription(text = Constants.PASSWORD_TEXT)

    CustomPasswordTextField(value = value, isNext = true, isError = isError) {
        onEmailChange(it)
    }

    if (isError)
        ErrorMessage(text = Constants.WEAK_PASSWORD_ERROR_TEXT)
}

@Composable
private fun ConfirmPasswordSection(value: String, isError: Boolean, onEmailChange: (String) -> Unit) {
    CustomInputDescription(text = Constants.CONFIRM_PASSWORD_TEXT)

    CustomPasswordTextField(value = value, text = Constants.REENTER_PASSWORD_PLACEHOLDER, isError = isError) {
        onEmailChange(it)
    }

    if (isError)
        ErrorMessage(text = Constants.CONFIRM_PASSWORD_ERROR_TEXT)
}

@Composable
private fun CreateAccountButton(
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
            text = Constants.SIGNUP_BUTTON_TEXT,
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.labelLarge,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun LoginLink(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = Constants.ACCOUNT_PROMPT,
            style = MaterialTheme.typography.labelSmall,
            color = Color(0xFF2F2E2E),
            fontWeight = FontWeight.SemiBold,
        )
        TextButton(onClick = { onClick() }) {
            Text(
                text = Constants.LOGIN_BUTTON_TEXT,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}