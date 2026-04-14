package com.example.netflixclone.data.model

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: Any,
    val backdropUrl: Any = "",
    val genre: String,
    val rating: Float,
    val year: Int,
    val isFeatured: Boolean = false,
    val isKids: Boolean = false,
    val contentType: String = "movie"  // "movie" or "tvshow"
)