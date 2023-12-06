package com.example.cluehack.viewModel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cluehack.data.DataSource
import com.example.cluehack.data.UiState
import com.example.cluehack.model.Board

private val data = DataSource()

@Composable
fun MapScreenView(
    modifier: Modifier,
    onChartScreenClick: () -> Unit = {},
    onSuggestionScreenClick: () -> Unit = {},
    uiState: UiState
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val board = Board(uiState)
        board.createBoard()

        LazyColumn(modifier = Modifier.height(1200.dp))
        {
            items(board.getBoard()) {list ->
                LazyRow() {
                    items(list) {cell ->
                        cell.CellButton()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MapScreenViewPreview() {
    MapScreenView(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        uiState = UiState(
            playerCharacters = data.loadCharacters()
        )
    )
}
