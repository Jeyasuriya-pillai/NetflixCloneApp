package com.example.netflixclone.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val NetflixColorScheme = darkColorScheme(
    primary = NetflixRed,
    background = NetflixBlack,
    surface = NetflixDarkGray,
    onBackground = White,
    onSurface = White,
    secondary = NetflixGray
)

@Composable
fun NetflixTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = NetflixColorScheme,
        typography = Typography(),
        content = content
    )
}