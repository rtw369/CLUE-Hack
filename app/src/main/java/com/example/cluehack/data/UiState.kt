package com.example.cluehack.data

import com.example.cluehack.R
import com.example.cluehack.model.ImageCard

data class UiState(
    // The characters that players will play.
    val playerCharacters: List<ImageCard> = listOf(),

    // The user's character. Default will be Miss Scarlett.
    val userCharacter: ImageCard = ImageCard(R.string.miss_scarlett, R.drawable.miss_scarlett, DataSource().red),

    // The state for determining how the button will change when pressed. The options are "Done", "Close", "Question".
    val currentStateForButtonInChartScreen: String = "Done",

    // A list that contains a list for every # of players that contains a string value that indicates whether that player holds certain card or not.
    // The default list will have everything "empty".
    val playerCardsChart: List<List<String>> = listOf(listOf("Not Available"))
)
