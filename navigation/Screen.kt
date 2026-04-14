package com.example.netflixclone.ui.navigation

sealed class Screen(val route: String) {
    object ProfileSelection : Screen("profile_selection")
    object Home : Screen("home")
    object Search : Screen("search")
    object Profile : Screen("profile")
    object MyList : Screen("mylist")
    object TvShows : Screen("tvshows")
    object Movies : Screen("movies")
    object ManageProfiles : Screen("manage_profiles")
    object Detail : Screen("detail/{movieId}") {
        fun createRoute(movieId: Int) = "detail/$movieId"
    }
}