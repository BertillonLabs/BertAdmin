package data

import kotlinx.serialization.Serializable

@Serializable
data class Agent(
    val address: String,
    val email: String,
    val login: String,
    val name: String
)
