package com.celisdev.userauthdemo.presentation.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailError: Boolean = false,
    val passwordError: Boolean = false,
)
