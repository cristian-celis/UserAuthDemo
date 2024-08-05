package com.celisdev.userauthdemo.presentation.signup

data class SignUpState(
    val email: String = "",
    val emailError: Boolean = false,
    val phoneNumber: String = "",
    val phoneNumberError: Boolean = false,
    val password: String = "",
    val passwordError: Boolean = false,
    val confirmPassword: String = "",
    val confirmPasswordError: Boolean = false
)
