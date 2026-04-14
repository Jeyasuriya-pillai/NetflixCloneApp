package com.example.netflixclone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.data.UserPreferences
import com.example.netflixclone.data.model.Movie
import com.example.netflixclone.ui.components.FeaturedBanner
import com.example.netflixclone.ui.components.MovieRow
import com.example.netflixclone.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onMovieClick: (Movie) -> Unit,
    onTvShowsClick: () -> Unit,
    onMoviesClick: () -> Unit,
    onMyListClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .statusBarsPadding(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "NETFLIX",
                    color = Color(0xFFE50914),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    letterSpacing = (-0.5).sp
                )
                Spacer(modifier = Modifier.width(20.dp))
                if (UserPreferences.currentProfile.value?.isKids == false) {
                    Text(
                        "TV Shows",
                        color = Color.White,
                        fontSize = 13.sp,
                        modifier = Modifier.clickable { onTvShowsClick() }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        "Movies",
                        color = Color.White,
                        fontSize = 13.sp,
                        modifier = Modifier.clickable { onMoviesClick() }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        "My List",
                        color = Color.White,
                        fontSize = 13.sp,
                        modifier = Modifier.clickable { onMyListClick() }
                    )
                } else {
                    Text("Kids", color = Color(0xFF0A5C8A), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        item {
            FeaturedBanner(
                movie = viewModel.featuredMovie,
                onPlayClick = { onMovieClick(viewModel.featuredMovie) },
                onInfoClick = { onMovieClick(viewModel.featuredMovie) }
            )
        }

        item {
            MovieRow("Trending Now", viewModel.trendingMovies, onMovieClick)
        }

        item {
            MovieRow("Popular on Netflix", viewModel.popularMovies, onMovieClick)
        }

        if (viewModel.myList.isNotEmpty()) {
            item {
                MovieRow("My List", viewModel.myList, onMovieClick)
            }
        }

        item { Spacer(modifier = Modifier.height(80.dp)) }
    }
}