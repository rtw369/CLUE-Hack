package com.example.cluehack.model

import com.example.cluehack.data.DataSource
import com.example.cluehack.data.UiState

data class Board(
    val uiState: UiState
) {
    private val initialBoard: List<List<String>> = listOf(
        /*0 */listOf("0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0", "0", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0"),
        /*1 */listOf("w", "w", "w", "w", "w", "w", "0", "1", "1", "1", "w", "w", "w", "w", "1", "1", "1", "0", "w", "w", "w", "w", "w", "w"),
        /*2 */listOf("w", "0", "0", "0", "0", "w", "1", "1", "w", "w", "w", "0", "0", "w", "w", "w", "1", "1", "w", "0", "0", "0", "0", "w"),
        /*3 */listOf("w", "0", "0", "0", "0", "w", "1", "1", "w", "0", "0", "0", "0", "0", "0", "w", "1", "1", "w", "0", "0", "0", "0", "w"),
        /*4 */listOf("w", "0", "0", "0", "0", "w", "1", "1", "w", "0", "0", "0", "0", "0", "0", "w", "1", "1", "d", "w", "0", "0", "w", "w"),
        /*5 */listOf("w", "w", "0", "0", "0", "w", "1", "1", "d", "0", "0", "0", "0", "0", "0", "d", "1", "1", "1", "w", "w", "w", "w", "0"),
        /*6 */listOf("0", "w", "w", "w", "d", "w", "1", "1", "w", "0", "0", "0", "0", "0", "0", "w", "1", "1", "1", "1", "1", "1", "1", "1"),
        /*7 */listOf("1", "1", "1", "1", "1", "1", "1", "1", "w", "d", "w", "w", "w", "w", "d", "w", "1", "1", "1", "1", "1", "1", "1", "0"),
        /*8 */listOf("0", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "w", "w", "w", "w", "w", "w"),
        /*9 */listOf("w", "w", "w", "w", "w", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "d", "0", "0", "0", "0", "w"),
        /*10*/listOf("w", "0", "0", "0", "w", "w", "w", "w", "1", "1", "w", "w", "w", "w", "w", "1", "1", "1", "w", "0", "0", "0", "0", "w"),
        /*11*/listOf("w", "0", "0", "0", "0", "0", "0", "w", "1", "1", "w", "0", "0", "0", "w", "1", "1", "1", "w", "0", "0", "0", "0", "w"),
        /*12*/listOf("w", "0", "0", "0", "0", "0", "0", "w", "1", "1", "w", "0", "0", "0", "w", "1", "1", "1", "w", "w", "w", "w", "d", "w"),
        /*13*/listOf("w", "0", "0", "0", "0", "0", "0", "w", "1", "1", "w", "0", "0", "0", "w", "1", "1", "1", "1", "1", "1", "1", "1", "0"),
        /*14*/listOf("w", "0", "0", "0", "0", "0", "0", "w", "1", "1", "w", "0", "0", "0", "w", "1", "1", "1", "w", "w", "d", "w", "w", "0"),
        /*15*/listOf("w", "w", "w", "w", "w", "w", "w", "w", "1", "1", "w", "0", "0", "0", "w", "1", "1", "w", "w", "0", "0", "0", "w", "w"),
        /*16*/listOf("0", "1", "1", "1", "1", "1", "1", "1", "1", "1", "w", "w", "w", "w", "w", "1", "1", "d", "0", "0", "0", "0", "0", "w"),
        /*17*/listOf("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "w", "w", "0", "0", "0", "w", "w"),
        /*18*/listOf("0", "1", "1", "1", "1", "1", "1", "1", "1", "w", "w", "d", "d", "w", "w", "1", "1", "1", "w", "w", "w", "w", "w", "0"),
        /*19*/listOf("w", "w", "w", "w", "w", "w", "d", "1", "1", "w", "0", "0", "0", "0", "w", "1", "1", "1", "1", "1", "1", "1", "1", "1"),
        /*20*/listOf("w", "0", "0", "0", "0", "0", "w", "1", "1", "w", "0", "0", "0", "0", "d", "1", "1", "1", "1", "1", "1", "1", "1", "0"),
        /*21*/listOf("w", "0", "0", "0", "0", "0", "w", "1", "1", "w", "0", "0", "0", "0", "w", "1", "1", "d", "w", "w", "w", "w", "w", "w"),
        /*22*/listOf("w", "0", "0", "0", "0", "0", "w", "1", "1", "w", "0", "0", "0", "0", "w", "1", "1", "w", "0", "0", "0", "0", "0", "w"),
        /*23*/listOf("w", "0", "0", "0", "0", "w", "w", "1", "1", "w", "0", "0", "0", "0", "w", "1", "1", "w", "w", "0", "0", "0", "0", "w"),
        /*24*/listOf("w", "w", "w", "w", "w", "w", "0", "1", "0", "w", "w", "w", "w", "w", "w", "0", "1", "0", "w", "w", "w", "w", "w", "w"),
    )

    private val empty = "0"
    private val path = "1"
    private val wall = "w"

    private val board = mutableListOf(mutableListOf<String>())
    private val playerStartingLocation = listOf(
        listOf(0, 9), // Dr. Orchid
        listOf(0, 14), // Reverend Green
        listOf(6, 23), // Mrs. Peacock
        listOf(17, 0), // Colonel Mustard
        listOf(19, 23), // Professor Plum
        listOf(24, 7) // Ms. Scarlett
        )

    @OptIn(ExperimentalStdlibApi::class)
    fun resetBoard() {
        for (row in 0..<initialBoard.count()) {
            var newBoardRow = mutableListOf<String>()
            for (col in 0..<initialBoard[row].count()) {
                when (initialBoard[row][col]) {
                    empty -> newBoardRow.add("empty")
                    path -> newBoardRow.add("path")
                    wall -> newBoardRow.add("wall")
                }

                if (playerStartingLocation.contains(listOf(row, col))) {
                    // Player needs to be added here.
                }
            }
            board.add(newBoardRow)
        }
    }

    fun getBoard(): List<List<String>> {
        return board
    }
}