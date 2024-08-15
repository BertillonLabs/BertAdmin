package presentation.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import design.*
import theme.primary


@Composable
fun LoginScreen() {

    val scope = rememberCoroutineScope()
    val viewModel = remember(scope){ LoginViewModel(scope) }
    val state by viewModel.state.collectAsState()

    LoginContent(state){ email, password ->
        viewModel.login(email, password)
    }

    state.error?.let {
        AdminDialog(
            title = "Error",
            message = it,
            onClose = { viewModel.resetError() }
        )
    }

}

@Composable
private fun LoginContent(
    state: LoginState,
    onLogin: (String, String) -> Unit
) {
    var email by remember { mutableStateOf("admin@bertillonlabs.com") }
    var password by remember { mutableStateOf("eldEvenItAgo") }

    Container(enableScroll = true) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Sign In",
            fontSize = 34.sp,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = primary
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            AdminTextField(
                text = email,
                onTextChange = { email = it },
                label = "Email",
                placeholder = "user@email.com",
                keyboardType = KeyboardType.Email,
                modifier = Modifier.width(it.maxWidth / 3).height(48.dp)
            )
            AdminSecureTextField(
                value = password,
                onValueChanged = { password = it },
                label = "Password",
                modifier = Modifier.width(it.maxWidth / 3).height(48.dp)
            )
        }

        ButtonAndProgressBarAnimation(state = state.isLoading) {
            AdminPrimaryButton(
                text = "Log in",
                onClick = { onLogin(email, password) },
                modifier = Modifier.width(it.maxWidth / 3)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }

}
