package com.celisdev.userauthdemo.presentation.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val success: Boolean = false,
    val errorMessage: String? = null
)
