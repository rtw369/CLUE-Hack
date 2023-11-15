package com.example.cluehack.viewModel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cluehack.data.DataSource
import com.example.cluehack.data.UiState

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
