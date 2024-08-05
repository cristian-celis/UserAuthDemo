package com.celisdev.userauthdemo.presentation.signup

import androidx.lifecycle.ViewModel
import com.celisdev.userauthdemo.utils.ValidationUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): ViewModel() {

    private val _signUpState = MutableStateFlow(SignUpState())
    val signUpState: StateFlow<SignUpState> = _signUpState

    fun onEmailChange(email: String) {
        _signUpState.value = _signUpState.value.copy(email = email)
    }
    fun onPhoneChange(phoneNumber: String) {
        _signUpState.value = _signUpState.value.copy(phoneNumber = phoneNumber)
    }
    fun onPasswordChange(password: String) {
        _signUpState.value = _signUpState.value.copy(password = password)
    }
    fun onConfirmPasswordChange(confirmPassword: String) {
        _signUpState.value = _signUpState.value.copy(confirmPassword = confirmPassword)
    }

    fun onCreateAccount() {
        val email = _signUpState.value.email
        val phoneNumber = _signUpState.value.phoneNumber
        val password = _signUpState.value.password
        val confirmPassword = _signUpState.value.confirmPassword

        _signUpState.value = _signUpState.value.copy(
            emailError = !ValidationUtils.isValidEmail(email),
            phoneNumberError = !ValidationUtils.isValidPhoneNumber(phoneNumber),
            passwordError = !ValidationUtils.isValidPassword(password),
            confirmPasswordError = !ValidationUtils.validatePasswordsMatch(password, confirmPassword)
        )
    }
}