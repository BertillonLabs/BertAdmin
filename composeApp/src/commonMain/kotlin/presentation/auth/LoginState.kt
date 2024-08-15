package presentation.auth

import io.kamel.core.Resource

data class LoginState(
    val isLoggedIn: Boolean? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean? = null
)
