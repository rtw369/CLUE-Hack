package com.example.cluehack.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cluehack.data.DataSource
import com.example.cluehack.data.UiState
import com.example.cluehack.model.ImageCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.EnumSet.range

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun changePlayerCharacters(newCharacter: ImageCard) {
        val currentPlayerCharacters = _uiState.value.playerCharacters

        if (currentPlayerCharacters.contains(newCharacter)) {
            // Remove character from list.
            val newPlayerCharacters = mutableListOf<ImageCard>()
            newPlayerCharacters.addAll(currentPlayerCharacters)
            newPlayerCharacters.remove(newCharacter)

            _uiState.update { currentState ->
                currentState.copy(
                    playerCharacters = newPlayerCharacters
                )
            }
        } else {
            // Add character to list.
            val newPlayerCharacters = mutableListOf<ImageCard>()
            newPlayerCharacters.addAll(currentPlayerCharacters)
            newPlayerCharacters.add(newCharacter)

            _uiState.update { currentState ->
                currentState.copy(
                    playerCharacters = newPlayerCharacters
                )
            }
        }
    }

    fun setUserCharacter(character: ImageCard) {
        _uiState.update { currentState ->
            currentState.copy(
                userCharacter = character
            )
        }
    }

    fun changeStateButton(state: String) {
        _uiState.update { currentState ->
            currentState.copy(
                currentStateForButtonInChartScreen = state
            )
        }
    }

    fun createPlayerCardChart() {
        val playerCardChart = mutableListOf<List<String>>()
        val numOfCharacters = DataSource().loadCharacters().count()
        val numOfWeapons = DataSource().loadWeapons().count()
        val numOfRooms = DataSource().loadRooms().count()

        val defaultPlayerCardChart = mutableListOf<String>()

        for (n in 1..(numOfCharacters + numOfWeapons + numOfRooms)) {
            defaultPlayerCardChart.add("Empty")
        }

        val numOfPlayers = _uiState.value.playerCharacters.count()

        for (n in 1..numOfPlayers) {
            playerCardChart.add(defaultPlayerCardChart)
        }

        _uiState.update { currentState ->
            currentState.copy(
                playerCardsChart = playerCardChart
            )
        }
    }

    fun changeChartState(index: List<Int>) {
        val n = index[0]
        val m = index[1]

        // Get the chart from uiState and copy it to a new variable.
        val uiStatePlayerCardsChart = _uiState.value.playerCardsChart.toMutableList()
        val newChart: MutableList<MutableList<String>> = mutableListOf<MutableList<String>>()
        for (item in uiStatePlayerCardsChart) {
            newChart.add(item.toMutableList())
        }

        // Change the chart as wanted.
        val newState = _uiState.value.currentStateForButtonInChartScreen
        if (newChart[n][m] == newState) {
            newChart[n][m] = "Empty"
        } else {
            newChart[n][m] = newState
        }

        // Update the uiState
        _uiState.update { currentState ->
            currentState.copy(
                playerCardsChart = newChart
            )
        }
    }
}