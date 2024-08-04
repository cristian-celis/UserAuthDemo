package com.celisdev.userauthdemo.presentation.login

import android.util.Log
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

    private val _rememberMe = MutableStateFlow(false)
    val rememberMe: StateFlow<Boolean> = _rememberMe

    fun onEmailChange(email: String) {
        _loginState.value = _loginState.value.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        _loginState.value = _loginState.value.copy(password = password)
    }

    fun onRememberMeChange(rememberMe: Boolean){
        _rememberMe.value = rememberMe
    }

    fun onLogin() {
        val email = _loginState.value.email
        val password = _loginState.value.password

        _loginState.value = _loginState.value.copy(
            emailError = !ValidationUtils.isValidEmail(email),
            passwordError = !ValidationUtils.isValidPassword(password)
        )
    }
}