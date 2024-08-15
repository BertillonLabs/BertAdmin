package data

import androidx.compose.ui.layout.LayoutCoordinates
import kotlinx.serialization.Serializable

@Serializable
data class Enrolle(
    val firstName: String, //bio
    val lastName: String, //bio
    val middleName: String, //bio
    val email: String, // contact
    val nextOfKin: String, // contact
    val location: String, // contact
    val gender: String, // bio
    val dob: String, //bio
    val passport: String, //bio
    val id: String, //bio-metrics
    val fingerprints: List<FingerPrints>, // biometrics
    val agent: String, // agent
    val userId: String,
    val idType: String,
    val phone: String,
    val uuid: String,
    val capturedCoordinates: String,
    val verifiedCoordinates: String,
    val enrolmentComplete: Boolean,
){

    val fullName = "$firstName $middleName $lastName"

    var agentData: Agent? = null
}

@Serializable
data class FingerPrints(
    val finger: String,
    val path: String
)
