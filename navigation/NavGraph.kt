package com.example.netflixclone.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.netflixclone.ui.screens.*
import com.example.netflixclone.viewmodel.HomeViewModel

@Composable
fun NavGraph(navController: NavHostController, viewModel: HomeViewModel) {
    NavHost(navController = navController, startDestination = Screen.ProfileSelection.route) {

        composable(Screen.ProfileSelection.route) {
            ProfileSelectionScreen(
                onProfileSelected = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.ProfileSelection.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                viewModel = viewModel,
                onMovieClick = { movie ->
                    viewModel.selectMovie(movie)
                    navController.navigate(Screen.Detail.createRoute(movie.id))
                },
                onTvShowsClick = { navController.navigate(Screen.TvShows.route) },
                onMoviesClick = { navController.navigate(Screen.Movies.route) },
                onMyListClick = { navController.navigate(Screen.MyList.route) }
            )
        }

        composable(Screen.Search.route) {
            SearchScreen(viewModel = viewModel, onMovieClick = { movie ->
                viewModel.selectMovie(movie)
                navController.navigate(Screen.Detail.createRoute(movie.id))
            })
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                onManageProfiles = { navController.navigate(Screen.ManageProfiles.route) },
                onSignOut = {
                    navController.navigate(Screen.ProfileSelection.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.TvShows.route) {
            TvShowsScreen(
                viewModel = viewModel,
                onMovieClick = { movie ->
                    viewModel.selectMovie(movie)
                    navController.navigate(Screen.Detail.createRoute(movie.id))
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Movies.route) {
            MoviesScreen(
                viewModel = viewModel,
                onMovieClick = { movie ->
                    viewModel.selectMovie(movie)
                    navController.navigate(Screen.Detail.createRoute(movie.id))
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.MyList.route) {
            MyListScreen(
                viewModel = viewModel,
                onMovieClick = { movie ->
                    viewModel.selectMovie(movie)
                    navController.navigate(Screen.Detail.createRoute(movie.id))
                },
                onBack = { navController.popBackStack() }  // yeh line add karo
            )
        }
        composable(Screen.ManageProfiles.route) {
            ManageProfilesScreen(onBack = { navController.popBackStack() })
        }

        composable(Screen.Detail.route) {
            DetailScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}