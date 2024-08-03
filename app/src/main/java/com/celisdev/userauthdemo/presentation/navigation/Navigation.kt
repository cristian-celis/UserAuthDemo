package com.celisdev.userauthdemo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.celisdev.userauthdemo.presentation.login.LogIn
import com.celisdev.userauthdemo.presentation.signup.SignUp

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LogIn.route){
        composable(route = Routes.LogIn.route){
            LogIn()
        }
        composable(route = Routes.SignUp.route){
            SignUp()
        }
    }
}