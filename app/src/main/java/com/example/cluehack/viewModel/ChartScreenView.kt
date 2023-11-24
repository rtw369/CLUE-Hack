package com.example.cluehack.viewModel

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cluehack.R
import com.example.cluehack.data.DataSource
import com.example.cluehack.data.UiState

@Composable
fun ChartScreenView(
    modifier: Modifier,
    uiState: UiState,
    onIconButtonClick: (String) -> Unit = {},
    onChartButtonClick: () -> Unit = {}
) {
    val characters = DataSource().loadCharacters()
    val weapons = DataSource().loadWeapons()
    val rooms = DataSource().loadRooms()

    val cellHeight = 45.dp
    val cellWidth = 45.dp
    val longCellWidth = 120.dp

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.height(600.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            LazyRow {
                item {
                    Text(
                        text = "",
                        modifier = Modifier
                            .width(longCellWidth)
                            .height(cellHeight)
                    )
                }
                items(uiState.playerCharacters.count()) { counter ->
                    TextButton(
                        modifier = Modifier
                            .width(45.dp)
                            .height(45.dp),
                        onClick = { /*TODO*/ },
                        shape = RectangleShape
                    ) {
                        Text(
                            text = "P${counter + 1}",
                            color = Color.White
                        )
                    }
                }
            }

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                LazyRow(
                    modifier = Modifier.height(1200.dp)
                ) {
                    item {
                        LazyColumn(userScrollEnabled = false) {
                            items(characters) {character ->
                                Text(
                                    modifier = Modifier
                                        .width(longCellWidth)
                                        .height(cellHeight)
                                        .padding(horizontal = 4.dp)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center,
                                    text = stringResource(character.stringResourceId),
                                    color = Color.White
                                )
                            }
                            item { Divider(modifier = Modifier.padding(vertical = 8.dp)) }
                            items(weapons) {weapon ->
                                Text(
                                    modifier = Modifier
                                        .width(longCellWidth)
                                        .height(cellHeight)
                                        .padding(horizontal = 4.dp)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center,
                                    text = stringResource(weapon.stringResourceId),
                                    color = Color.White
                                )
                            }
                            item { Divider(modifier = Modifier.padding(vertical = 8.dp)) }
                            items(rooms) {room ->
                                Text(
                                    modifier = Modifier
                                        .width(longCellWidth)
                                        .height(cellHeight)
                                        .padding(horizontal = 4.dp)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center,
                                    text = stringResource(room.stringResourceId),
                                    color = Color.White
                                )
                            }
                        }
                    }

                    items(uiState.playerCharacters.count()) {_ ->
                        LazyColumn(userScrollEnabled = false) {
                            items(characters.count()) {_ ->
                                ChartButton()
                            }
                            item { Divider(modifier = Modifier.padding(vertical = 8.dp)) }
                            items(weapons.count()) {_ ->
                                ChartButton()
                            }
                            item { Divider(modifier = Modifier.padding(vertical = 8.dp)) }
                            items(rooms.count()) {_ ->
                                ChartButton()
                            }
                        }
                    }
                }
            }
        }

        Divider(modifier = Modifier.padding(vertical = 36.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { onIconButtonClick("Done") }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Done,
                    contentDescription = stringResource(R.string.done),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            IconButton(onClick = { onIconButtonClick("Close") }) {
                Icon(
                    imageVector = Icons.Outlined.Close,
                    contentDescription = stringResource(R.string.close),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            IconButton(onClick = { onIconButtonClick("Question") }) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = stringResource(R.string.question_mark),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                )
            }
        }
    }
}

@Composable
fun ChartButton(
    onClick: () -> Unit = {}
) {
    ElevatedButton(
        modifier = Modifier
            .width(45.dp)
            .height(45.dp),
        onClick = { onClick() },
        shape = RectangleShape,
        border = BorderStroke(1.dp, Color.White),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {}
}

@Preview
@Composable
fun CharScreenViewPreview() {
    ChartScreenView(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        uiState = UiState(playerCharacters = DataSource().loadCharacters())
    )
}