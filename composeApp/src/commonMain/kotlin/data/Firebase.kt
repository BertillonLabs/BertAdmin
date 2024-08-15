package data

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.initialize

object FirebaseBackend {

    private val options = FirebaseOptions(
        applicationId = "1:326860137849:web:15e6e40453b68150247ba8",
        apiKey = "AIzaSyBd-e_HJn9io5MldoMGCAoMC6-7XpKCU9A",
        projectId = "tezzy-bertillon",
        authDomain = "tezzy-bertillon.firebaseapp.com"
    )

    val app = Firebase.initialize(options = options)
}