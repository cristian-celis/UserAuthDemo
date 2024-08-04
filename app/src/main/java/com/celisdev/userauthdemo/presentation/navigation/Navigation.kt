package com.celisdev.userauthdemo.presentation.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.celisdev.userauthdemo.presentation.login.LogIn
import com.celisdev.userauthdemo.presentation.signup.SignUp
import kotlinx.coroutines.CoroutineScope

@Composable
fun Navigation(
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LogIn.route){
        composable(route = Routes.LogIn.route){
            LogIn(scope, snackbarHostState, navController)
        }
        composable(route = Routes.SignUp.route){
            SignUp(scope, snackbarHostState, navController)
        }
    }
}