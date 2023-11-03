package com.example.cluehack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cluehack.viewModel.StartingScreenView

enum class Screen() {
    StartingScreen,
    ChartScreen,
    SuggestionsScreen,
    MapScreen,
}

@Composable
fun ClueHackApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
        .fillMaxSize()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.StartingScreen.name,
        modifier = Modifier.padding(32.dp)
    ) {
        composable(route = Screen.StartingScreen.name) {
            StartingScreenView(modifier = modifier)
        }
    }
}