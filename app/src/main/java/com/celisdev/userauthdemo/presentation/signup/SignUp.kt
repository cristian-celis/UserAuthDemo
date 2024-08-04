package com.celisdev.userauthdemo.presentation.signup

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun SignUp(
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {

}