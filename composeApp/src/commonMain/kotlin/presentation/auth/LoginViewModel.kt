package presentation.auth

import data.FirebaseBackend
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuthInvalidCredentialsException
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val viewmodelScope: CoroutineScope
) {
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    private val auth = Firebase.auth(FirebaseBackend.app)
    private val store = Firebase.firestore(FirebaseBackend.app)

    init {
        viewmodelScope.launch {
            auth.authStateChanged.collectLatest { user ->
                _state.update {
                    it.copy(isLoggedIn = user != null)
                }
            }
        }


    }


    fun login(email: String, password: String){
        viewmodelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val result = runCatching { auth.signInWithEmailAndPassword(email, password) }
            result.onSuccess { auth ->
                val user = store.collection("admin").document(auth.user?.uid.orEmpty()).get()
                _state.update { it.copy(isLoading = false, isLoggedIn = user.exists) }
            }.onFailure { error ->
                _state.update { it.copy(isLoading = false, error = "Invalid credentials") }
            }
        }
    }

    fun resetError(){
        _state.update { it.copy(error = null) }
    }
}