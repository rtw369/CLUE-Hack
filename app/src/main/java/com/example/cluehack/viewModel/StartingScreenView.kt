package com.example.cluehack.viewModel

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cluehack.model.ImageCard
import com.example.cluehack.data.DataSource
import com.example.cluehack.data.UiState

@Composable
fun StartingScreenView(
    modifier: Modifier = Modifier,
    onButtonClick: (ImageCard) -> Unit = {},
    uiState: UiState
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PlayerButton(Color.Red, onClick = onButtonClick)
                PlayerButton(Color.Green, onClick = onButtonClick)
                PlayerButton(Color.Yellow, onClick = onButtonClick)
            }

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PlayerButton(Color.Magenta, onClick = onButtonClick)
                PlayerButton(Color.Blue, onClick = onButtonClick)
                PlayerButton(Color.White, onClick = onButtonClick)
            }
        }

        Spacer(modifier = Modifier.height(80.dp))

        CharacterCardsRow(uiState)
    }
}

@Composable
fun PlayerButton(
    color: Color = Color.Black,
    onClick: (ImageCard) -> Unit = {}
) {
    var selected by remember { mutableStateOf(false) }
    val borderWidth = if (selected) 4 else -1
    val character = DataSource().loadCharacter(color)

    Button(
        modifier = Modifier
            .height(108.dp)
            .width(108.dp)
            .padding(8.dp),
        onClick = {
            selected = !selected
            onClick(character)
                  },
        colors = ButtonDefaults.buttonColors(containerColor = color),
        border = BorderStroke(borderWidth.dp, Color.Black),
        shape = RectangleShape
        ) {}
}

@Composable
fun CharacterCardsRow(uiState: UiState) {
    LazyRow(
        modifier = Modifier
            .height(300.dp)
    ) {
        items(uiState.playerCharacters) {card ->
            CharacterCard(card)
        }
    }
}

@Composable
fun CharacterCard(card: ImageCard) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(170.dp)
            .height(250.dp)
    ) {
        Image(
            painter = painterResource(card.drawableResourceId),
            contentDescription = stringResource(card.stringResourceId),
            modifier = Modifier
                .width(170.dp)
                .height(250.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview
@Composable
fun StartingScreenViewPreview() {
    StartingScreenView(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        uiState = UiState(
            playerCharacters = DataSource().loadCharacters()
        )
    )
}