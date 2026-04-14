package com.example.netflixclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.netflixclone.ui.navigation.NavGraph
import com.example.netflixclone.ui.navigation.Screen
import com.example.netflixclone.ui.theme.NetflixTheme
import com.example.netflixclone.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixTheme {
                val navController = rememberNavController()
                val viewModel: HomeViewModel = viewModel()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val hideBottomBarRoutes = listOf(
                    Screen.ProfileSelection.route,
                    Screen.Detail.route,
                    Screen.ManageProfiles.route
                )
                val showBottomBar = currentRoute !in hideBottomBarRoutes

                Scaffold(
                    containerColor = Color.Black,
                    bottomBar = {
                        if (showBottomBar) {
                            NavigationBar(containerColor = Color(0xFF141414)) {
                                listOf(
                                    Triple(Screen.Home.route, Icons.Default.Home, "Home"),
                                    Triple(Screen.Search.route, Icons.Default.Search, "Search"),
                                    Triple(Screen.Profile.route, Icons.Default.Person, "Profile"),
                                ).forEach { (route, icon, label) ->
                                    NavigationBarItem(
                                        selected = currentRoute == route,
                                        onClick = {
                                            if (currentRoute != route) {
                                                navController.navigate(route) {
                                                    popUpTo(Screen.Home.route) { saveState = true }
                                                    launchSingleTop = true
                                                    restoreState = true
                                                }
                                            }
                                        },
                                        icon = { Icon(icon, contentDescription = label) },
                                        label = { Text(label) },
                                        colors = NavigationBarItemDefaults.colors(
                                            selectedIconColor = Color.White,
                                            selectedTextColor = Color.White,
                                            unselectedIconColor = Color.Gray,
                                            unselectedTextColor = Color.Gray,
                                            indicatorColor = Color.Transparent
                                        )
                                    )
                                }
                            }
                        }
                    }
                ) { _ ->
                    NavGraph(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}