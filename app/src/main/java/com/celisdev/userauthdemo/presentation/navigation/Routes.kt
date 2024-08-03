package com.celisdev.userauthdemo.presentation.navigation

sealed class Routes (val route: String){
    data object SignUp: Routes("sign_up")
    data object LogIn: Routes("log_in")
}