package com.example.cluehack.data

import com.example.cluehack.R
import com.example.cluehack.model.ImageCard

data class UiState(
    // The characters that players will play.
    val playerCharacters: List<ImageCard> = listOf(),

    // The user's character. Default will be Miss Scarlett.
    val userCharacter: ImageCard = ImageCard(R.string.miss_scarlett, R.drawable.miss_scarlett, DataSource().red)
)
