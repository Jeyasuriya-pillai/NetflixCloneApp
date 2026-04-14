package com.example.netflixclone.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.netflixclone.data.model.Movie

object UserPreferences {
    val currentProfile = mutableStateOf<AppProfile?>(null)

    val myList = mutableStateListOf<Movie>()

    fun addToMyList(movie: Movie) {
        if (myList.none { it.id == movie.id }) myList.add(movie)
    }

    fun removeFromMyList(movie: Movie) {
        myList.removeAll { it.id == movie.id }
    }

    fun isInMyList(movie: Movie): Boolean = myList.any { it.id == movie.id }

    fun signOut() {
        currentProfile.value = null
        myList.clear()
    }
}

data class AppProfile(
    val name: String,
    val avatarColor: Long,
    val avatarLetter: String,
    val isKids: Boolean = false
)