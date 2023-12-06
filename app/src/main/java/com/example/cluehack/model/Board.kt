package com.example.cluehack.model

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cluehack.data.DataSource
import com.example.cluehack.data.UiState

data class Board(
    val uiState: UiState
) {
    private val initialBoard: List<List<String>> = listOf(
        //            0    1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17   18   19   20   21   22   23
        /*0 */listOf("0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0", "0", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0"),
        /*1 */listOf("r", "r", "r", "r", "r", "r", "0", "1", "1", "1", "r", "r", "r", "r", "1", "1", "1", "0", "r", "r", "r", "r", "r", "r"),
        /*2 */listOf("r", "r", "r", "r", "r", "r", "1", "1", "r", "r", "r", "r", "r", "r", "r", "r", "1", "1", "r", "r", "r", "r", "r", "r"),
        /*3 */listOf("r", "r", "r", "r", "r", "r", "1", "1", "r", "r", "r", "r", "r", "r", "r", "r", "1", "1", "r", "r", "r", "r", "r", "r"),
        /*4 */listOf("r", "r", "r", "r", "r", "r", "1", "1", "r", "r", "r", "r", "r", "r", "r", "r", "1", "1", "d", "r", "r", "r", "r", "r"),
        /*5 */listOf("r", "r", "r", "r", "r", "r", "1", "1", "d", "r", "r", "r", "r", "r", "r", "d", "1", "1", "1", "r", "r", "r", "r", "0"),
        /*6 */listOf("0", "r", "r", "r", "d", "r", "1", "1", "r", "r", "r", "r", "r", "r", "r", "r", "1", "1", "1", "1", "1", "1", "1", "1"),
        /*7 */listOf("1", "1", "1", "1", "1", "1", "1", "1", "r", "d", "r", "r", "r", "r", "d", "r", "1", "1", "1", "1", "1", "1", "1", "0"),
        /*8 */listOf("0", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "r", "r", "r", "r", "r", "r"),
        /*9 */listOf("r", "r", "r", "r", "r", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "d", "r", "r", "r", "r", "r"),
        /*10*/listOf("r", "r", "r", "r", "r", "r", "r", "r", "1", "1", "0", "0", "0", "0", "0", "1", "1", "1", "r", "r", "r", "r", "r", "r"),
        /*11*/listOf("r", "r", "r", "r", "r", "r", "r", "r", "1", "1", "0", "0", "0", "0", "0", "1", "1", "1", "r", "r", "r", "r", "r", "r"),
        /*12*/listOf("r", "r", "r", "r", "r", "r", "r", "d", "1", "1", "0", "0", "0", "0", "0", "1", "1", "1", "r", "r", "r", "r", "d", "r"),
        /*13*/listOf("r", "r", "r", "r", "r", "r", "r", "r", "1", "1", "0", "0", "0", "0", "0", "1", "1", "1", "1", "1", "1", "1", "1", "0"),
        /*14*/listOf("r", "r", "r", "r", "r", "r", "r", "r", "1", "1", "0", "0", "0", "0", "0", "1", "1", "1", "r", "r", "d", "r", "r", "0"),
        /*15*/listOf("r", "r", "r", "r", "r", "r", "d", "r", "1", "1", "0", "0", "0", "0", "0", "1", "1", "r", "r", "r", "r", "r", "r", "r"),
        /*16*/listOf("0", "1", "1", "1", "1", "1", "1", "1", "1", "1", "0", "0", "0", "0", "0", "1", "1", "d", "r", "r", "r", "r", "r", "r"),
        /*17*/listOf("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "r", "r", "r", "r", "r", "r", "r"),
        /*18*/listOf("0", "1", "1", "1", "1", "1", "1", "1", "1", "r", "r", "d", "d", "r", "r", "1", "1", "1", "r", "r", "r", "r", "r", "0"),
        /*19*/listOf("r", "r", "r", "r", "r", "r", "d", "1", "1", "r", "r", "r", "r", "r", "r", "1", "1", "1", "1", "1", "1", "1", "1", "1"),
        /*20*/listOf("r", "r", "r", "r", "r", "r", "r", "1", "1", "r", "r", "r", "r", "r", "d", "1", "1", "1", "1", "1", "1", "1", "1", "0"),
        /*21*/listOf("r", "r", "r", "r", "r", "r", "r", "1", "1", "r", "r", "r", "r", "r", "r", "1", "1", "d", "r", "r", "r", "r", "r", "r"),
        /*22*/listOf("r", "r", "r", "r", "r", "r", "r", "1", "1", "r", "r", "r", "r", "r", "r", "1", "1", "r", "r", "r", "r", "r", "r", "r"),
        /*23*/listOf("r", "r", "r", "r", "r", "r", "r", "1", "1", "r", "r", "r", "r", "r", "r", "1", "1", "r", "r", "r", "r", "r", "r", "r"),
        /*24*/listOf("r", "r", "r", "r", "r", "r", "0", "1", "0", "r", "r", "r", "r", "r", "r", "0", "1", "0", "r", "r", "r", "r", "r", "r"),
    )

    private val empty = "0"
    private val path = "1"
    private val room = "r"
    private val door = "d"

    private var board = mutableListOf<MutableList<Cell>>()
    private val playerStartingLocation = listOf(
        listOf(0, 9), // Dr. Orchid
        listOf(0, 14), // Reverend Green
        listOf(6, 23), // Mrs. Peacock
        listOf(17, 0), // Colonel Mustard
        listOf(19, 23), // Professor Plum
        listOf(24, 7) // Ms. Scarlett
        )

    fun createBoard() {
        board = mutableListOf<MutableList<Cell>>()
        var opt = "None"

        for (n in 0 until initialBoard.count()) {
            var newList = mutableListOf<Cell>()
            for (m in 0 until initialBoard[n].count()) {
                val item = initialBoard[n][m]
                when (item) {
                    empty -> opt = "None"
                    path -> opt = if (listOf(n, m) in playerStartingLocation) "Player" else "None"
                    room -> opt = "None"
                    door -> opt = "Door"
                }

                newList.add(Cell(item, option = opt))
            }
            board.add(newList)
        }
    }

    fun getBoard(): List<List<Cell>> {
        return board
    }
}

data class Cell(
    // state is one of the following: Empty, Room, Path
    var state: String,

    // option contains information: if path, has what player; if room, which sides has the wall or doorway.
    var option: String = "None"
) {
    @Composable
    fun CellButton() {
        TextButton(modifier = Modifier
            .width(45.dp)
            .height(45.dp),
            onClick = {  },
            shape = RectangleShape,
            border = BorderStroke(1.dp, Color.White),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)) {
            Text(
                text = option,
                color = Color.White,
                fontSize = 8.sp
            )
        }
    }
}