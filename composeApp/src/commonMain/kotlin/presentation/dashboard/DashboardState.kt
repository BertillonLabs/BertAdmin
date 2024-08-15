package presentation.dashboard

import data.Agent
import data.Enrolle

data class DashboardState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val agents: List<Agent> = listOf(),
    val enrolles: List<Enrolle> = listOf()
)
