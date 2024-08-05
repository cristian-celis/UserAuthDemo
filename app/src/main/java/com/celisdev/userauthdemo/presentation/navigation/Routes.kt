package com.celisdev.userauthdemo.presentation.navigation

import com.celisdev.userauthdemo.core.Constants

sealed class Routes (val route: String){
    data object SignUp: Routes(Constants.SIGN_UP_ROUTE)
    data object LogIn: Routes(Constants.LOG_IN_ROUTE)
}