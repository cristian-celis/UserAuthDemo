package com.celisdev.userauthdemo.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.celisdev.userauthdemo.utils.ValidationUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(): ViewModel() {

    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState

    fun onEmailChange(email: String) {
        _loginState.value = _loginState.value.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        _loginState.value = _loginState.value.copy(password = password)
    }

    fun onLogin() {
        val email = _loginState.value.email
        val password = _loginState.value.password

        when {
            email.isEmpty() || password.isEmpty() -> {
                _loginState.value = _loginState.value.copy(errorMessage = "Cadena vacia")
            }

            !ValidationUtils.isValidEmail(email) -> {
                _loginState.value = _loginState.value.copy(errorMessage = "Error en el email")
            }

            else -> {
                _loginState.value = _loginState.value.copy(success = true, errorMessage = null)
            }
        }
    }
}