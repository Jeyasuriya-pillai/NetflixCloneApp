package com.example.netflixclone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
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
fun ManageProfilesScreen(onBack: () -> Unit) {
    val profiles = listOf(
        AppProfile("Jeyasuriya", 0xFF831010, "J", isKids = false),
        AppProfile("Children", 0xFF0A5C8A, "K", isKids = true)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text("Manage Profiles", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(32.dp))

        profiles.forEach { profile ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(profile.avatarColor)),
                    contentAlignment = Alignment.Center
                ) {
                    if (profile.isKids) {
                        Text("👶", fontSize = 28.sp)
                    } else {
                        Text(profile.avatarLetter, color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(profile.name, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    if (profile.isKids) {
                        Text("Kids Profile", color = Color(0xFF0A5C8A), fontSize = 12.sp)
                    } else {
                        Text("Standard Plan", color = Color.Gray, fontSize = 12.sp)
                    }
                }

                IconButton(onClick = {}) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit", tint = Color.Gray)
                }
            }

            Divider(color = Color(0xFF2A2A2A))
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
        ) {
            Text("+ Add Profile")
        }
    }
}