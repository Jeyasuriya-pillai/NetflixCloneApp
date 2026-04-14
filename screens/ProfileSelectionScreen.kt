package com.example.netflixclone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.data.AppProfile
import com.example.netflixclone.data.UserPreferences

@Composable
fun ProfileSelectionScreen(onProfileSelected: () -> Unit) {
    val profiles = listOf(
        AppProfile("Jeyasuriya", 0xFF831010, "J", isKids = false),
        AppProfile("Children", 0xFF0A5C8A, "K", isKids = true)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "NETFLIX",
            color = Color(0xFFE50914),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = (-1).sp
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "Who's watching?",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.height(40.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
            profiles.forEach { profile ->
                ProfileCard(profile = profile) {
                    UserPreferences.currentProfile.value = profile
                    onProfileSelected()
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Manage Profiles button
        Box(
            modifier = Modifier
                .border(1.dp, Color.Gray, RoundedCornerShape(2.dp))
                .clickable { }
                .padding(horizontal = 20.dp, vertical = 8.dp)
        ) {
            Text("Manage Profiles", color = Color.White, fontSize = 14.sp)
        }
    }
}

@Composable
fun ProfileCard(profile: AppProfile, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(profile.avatarColor)),
            contentAlignment = Alignment.Center
        ) {
            if (profile.isKids) {
                Text("👶", fontSize = 44.sp)
            } else {
                Text(
                    text = profile.avatarLetter,
                    color = Color.White,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = profile.name,
            color = Color(0xFFB3B3B3),
            fontSize = 14.sp
        )
        if (profile.isKids) {
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFF0A5C8A))
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text("KIDS", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}