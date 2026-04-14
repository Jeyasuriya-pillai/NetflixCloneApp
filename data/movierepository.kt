package com.example.netflixclone.data.repository

import com.example.netflixclone.R
import com.example.netflixclone.data.model.Movie

object MovieRepository {

    val featuredMovie = Movie(
        id = 1,
        title = "Stranger Things",
        description = "Supernatural forces aur secret government experiments, ek choti si ladki ka gaayab hona — sab kuch connected hai is ek raaz se.",
        imageUrl = R.drawable.stranger_things,
        backdropUrl = R.drawable.stranger_things,
        genre = "Sci-Fi",
        rating = 8.7f,
        year = 2022,
        isFeatured = true,
        isKids = false,
        contentType = "tvshow"
    )

    val tvShows = listOf(
        Movie(1, "Stranger Things", "Supernatural mystery in a small town.", R.drawable.stranger_things, 0, "Sci-Fi", 8.7f, 2022, contentType = "tvshow"),
        Movie(2, "Money Heist", "Ek mastermind aur uski team ka perfect heist.", R.drawable.money_heist, 0, "Crime", 8.3f, 2021, contentType = "tvshow"),
        Movie(3, "Dark", "Time travel aur family secrets.", R.drawable.dark, 0, "Sci-Fi", 8.8f, 2020, contentType = "tvshow"),
        Movie(4, "Breaking Bad", "Ek chemistry teacher drug lord ban jaata hai.", R.drawable.breaking_bad, 0, "Drama", 9.5f, 2013, contentType = "tvshow"),
        Movie(5, "Wednesday", "Wednesday Addams ki school adventures.", R.drawable.wednesday, 0, "Comedy", 8.1f, 2022, contentType = "tvshow"),
        Movie(6, "Ozark", "Money laundering thriller.", R.drawable.ozark, 0, "Crime", 8.4f, 2022, contentType = "tvshow"),
    )

    val movies = listOf(
        Movie(10, "The Irishman", "A mob hitman recalls his involvement.", R.drawable.the_irishman, 0, "Crime", 7.8f, 2019, contentType = "movie"),
        Movie(11, "Bird Box", "Mysterious force blinds people.", R.drawable.bird_box, 0, "Thriller", 6.6f, 2018, contentType = "movie"),
        Movie(12, "Extraction", "Black market mercenary on mission.", R.drawable.extraction, 0, "Action", 6.7f, 2020, contentType = "movie"),
        Movie(13, "Red Notice", "FBI sting operation gone wrong.", R.drawable.red_notice, 0, "Action", 6.3f, 2021, contentType = "movie"),
        Movie(14, "The Gray Man", "CIA operative vs assassin.", R.drawable.the_gray_man, 0, "Action", 6.4f, 2022, contentType = "movie"),
    )

    val kidsContent = listOf(
        Movie(20, "Kung Fu Panda", "A panda becomes a kung fu master.", R.drawable.kung_fu_panda, 0, "Animation", 7.6f, 2008, isKids = true, contentType = "movie"),
        Movie(21, "Moana", "A Hawaiian girl's ocean adventure.", R.drawable.moana, 0, "Animation", 7.6f, 2016, isKids = true, contentType = "movie"),
        Movie(22, "Enola Holmes", "Sherlock Holmes ki choti behen.", R.drawable.enola_holmes, 0, "Adventure", 6.6f, 2020, isKids = true, contentType = "movie"),
        Movie(23, "The Mitchells vs Machines", "Family saves world from robots.", R.drawable.the_mitchells_vs_the_machines, 0, "Animation", 7.7f, 2021, isKids = true, contentType = "movie"),
    )

    val trendingMovies = tvShows.take(3) + movies.take(2)
    val popularMovies = movies + tvShows.takeLast(3)
}