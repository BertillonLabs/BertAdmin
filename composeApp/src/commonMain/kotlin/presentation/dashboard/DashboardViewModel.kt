package presentation.dashboard

import data.Agent
import data.Enrolle
import data.FirebaseBackend
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import presentation.auth.LoginState

class DashboardViewModel(
    private val scope: CoroutineScope
) {
    private val _state = MutableStateFlow(DashboardState())
    val state = _state.asStateFlow()

    private val store = Firebase.firestore
    init {
        store.setSettings(persistenceEnabled = false)
    }

    fun loadAgents(){
        scope.launch {
            _state.update { it.copy(isLoading = true) }
            val result = runCatching {
                store.collection("agents").snapshots
                    .map { s -> s.documents.map { it.data<Agent>() } }
                    .first()
            }
            result.onSuccess { agents ->
                println("Agents: ${agents.size}")
                _state.update { it.copy(isLoading = false, agents = agents) }
            }.onFailure { error ->
                println("Agents: ${error.message}")
                _state.update { it.copy(isLoading = false, error = error.message) }
            }
        }
    }

    fun loadEnrolles(){
        scope.launch {
            _state.update { it.copy(isLoading = true) }
            val result = runCatching {
                store.collection("enrolled").snapshots
                    .map { s ->
                        s.documents.map {
                            println("User: ${it.id}, ${it.exists}")
                            if (it.exists) it.data<Enrolle>() else null
                        }
                    }.first().filterNotNull()
                    .map {
                        val agent = store.collection("agents").document(it.agent).get().data<Agent>()
                        it.agentData = agent
                        it
                    }
            }
            result.onSuccess { enrolles ->
                _state.update { it.copy(isLoading = false, enrolles = enrolles) }
            }.onFailure { error ->
                println("Agents...: ${error.message}")
                _state.update { it.copy(isLoading = false, error = error.message) }
            }
        }
    }
    fun resetError(){
        _state.update { it.copy(error = null) }
    }
}