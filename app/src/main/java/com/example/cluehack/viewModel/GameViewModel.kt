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
}