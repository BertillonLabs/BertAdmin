package presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import design.Loading
import presentation.auth.LoginScreen
import presentation.auth.LoginViewModel
import presentation.dashboard.DashboardScreen

@Composable
fun App(){
    val scope = rememberCoroutineScope()
    val viewModel = remember(scope){ LoginViewModel(scope) }
    val state by viewModel.state.collectAsState()

    if (state.isLoggedIn == null) {
        Box(modifier = Modifier.fillMaxSize()) {
            Loading(Modifier.align(Alignment.Center))
        }
    }else {
        if (state.isLoggedIn == true) {
            DashboardScreen()
        } else {
            LoginScreen()
        }
    }
}