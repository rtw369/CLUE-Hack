package com.example.cluehack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cluehack.viewModel.ChartScreenView
import com.example.cluehack.viewModel.GameViewModel
import com.example.cluehack.viewModel.MapScreenView
import com.example.cluehack.viewModel.StartingScreenView

enum class Screen() {
    StartingScreen,
    ChartScreen,
    SuggestionsScreen,
    MapScreen,
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClueHackApp(
    viewModel: GameViewModel = GameViewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
        .fillMaxSize()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.StartingScreen.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screen.StartingScreen.name) {
                StartingScreenView(
                    modifier = modifier,
                    onButtonClick = { viewModel.changePlayerCharacters(it) },
                    onConfirmClick = { viewModel.setUserCharacter(it) },
                    onNextButtonClick = { navController.navigate(Screen.ChartScreen.name) },
                    uiState = uiState
                )
            }

            composable(route = Screen.MapScreen.name) {
                MapScreenView(
                    modifier = modifier,
                    uiState = uiState
                )
            }

            composable(route = Screen.ChartScreen.name) {
                ChartScreenView(
                    modifier = modifier,
                    uiState = uiState,
                    onIconButtonClick = { viewModel.changeStateButton(it) }
                )
            }
        }
    }
}