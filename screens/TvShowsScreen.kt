package com.example.netflixclone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.data.model.Movie
import com.example.netflixclone.ui.components.MovieRow
import com.example.netflixclone.viewmodel.HomeViewModel

@Composable
fun TvShowsScreen(
    viewModel: HomeViewModel,
    onMovieClick: (Movie) -> Unit,
    onBack: () -> Unit
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
                    .statusBarsPadding()
                    .padding(horizontal = 4.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Text(
                    text = "TV Shows",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        item {
            MovieRow(
                title = "Popular TV Shows",
                movies = viewModel.tvShows,
                onMovieClick = onMovieClick
            )
        }

        item {
            MovieRow(
                title = "Trending Series",
                movies = viewModel.tvShows.reversed(),
                onMovieClick = onMovieClick
            )
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}