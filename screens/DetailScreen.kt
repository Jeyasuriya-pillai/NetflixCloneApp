package com.example.netflixclone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.netflixclone.viewmodel.HomeViewModel

@Composable
fun DetailScreen(viewModel: HomeViewModel, onBack: () -> Unit) {
    val movie = viewModel.selectedMovie.collectAsState().value ?: return
    var inMyList by remember { mutableStateOf(viewModel.isInMyList(movie)) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Box {
            val backdrop = if (movie.backdropUrl is String && (movie.backdropUrl as String).isEmpty()) {
                movie.imageUrl
            } else if (movie.backdropUrl is Int && movie.backdropUrl == 0) {
                movie.imageUrl
            } else {
                movie.backdropUrl
            }

            AsyncImage(
                model = backdrop,
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(280.dp)
            )
            IconButton(
                onClick = onBack,
                modifier = Modifier.align(Alignment.TopStart).padding(8.dp)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(movie.title, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("${movie.year}", color = Color.Gray, fontSize = 13.sp)
                Box(
                    modifier = Modifier
                        .background(Color(0xFF333333))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        if (movie.isKids) "U/A 7+" else "U/A 16+",
                        color = Color.White,
                        fontSize = 11.sp
                    )
                }
                Text(movie.genre, color = Color.Gray, fontSize = 13.sp)
                Text("⭐ ${movie.rating}", color = Color.Gray, fontSize = 13.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("▶ Play", color = Color.Black, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                onClick = {
                    viewModel.toggleMyList(movie)
                    inMyList = viewModel.isInMyList(movie)
                },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = if (inMyList) Icons.Default.Check else Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(if (inMyList) "Added to My List" else "Add to My List")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "About",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(6.dp))

            Text(
                movie.description,
                color = Color.LightGray,
                fontSize = 14.sp,
                lineHeight = 22.sp
            )
        }
    }
}