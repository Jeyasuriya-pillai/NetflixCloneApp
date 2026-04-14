package com.example.netflixclone.viewmodel

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.example.netflixclone.data.UserPreferences
import com.example.netflixclone.data.model.Movie
import com.example.netflixclone.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val _selectedMovie = MutableStateFlow<Movie?>(null)
    val selectedMovie: StateFlow<Movie?> = _selectedMovie

    val isKidsProfile get() = UserPreferences.currentProfile.value?.isKids == true

    val featuredMovie = MovieRepository.featuredMovie

    val trendingMovies get() = if (isKidsProfile)
        MovieRepository.kidsContent else MovieRepository.trendingMovies

    val popularMovies get() = if (isKidsProfile)
        MovieRepository.kidsContent.reversed() else MovieRepository.popularMovies

    val tvShows get() = MovieRepository.tvShows

    val moviesList get() = MovieRepository.movies

    val myList get() = UserPreferences.myList.toList()

    fun selectMovie(movie: Movie) {
        _selectedMovie.value = movie
    }

    fun toggleMyList(movie: Movie) {
        if (UserPreferences.isInMyList(movie)) {
            UserPreferences.removeFromMyList(movie)
        } else {
            UserPreferences.addToMyList(movie)
        }
    }

    fun isInMyList(movie: Movie) = UserPreferences.isInMyList(movie)
}