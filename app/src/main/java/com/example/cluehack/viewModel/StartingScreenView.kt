package com.example.cluehack.viewModel

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

private val data = DataSource()

@Composable
fun StartingScreenView(
    modifier: Modifier = Modifier,
    onButtonClick: (ImageCard) -> Unit = {},
    onConfirmClick: (ImageCard) -> Unit = {},
    onNextButtonClick: () -> Unit = {},
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
                PlayerButton(data.red, onClick = onButtonClick)
                PlayerButton(data.green, onClick = onButtonClick)
                PlayerButton(data.yellow, onClick = onButtonClick)
            }

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PlayerButton(data.purple, onClick = onButtonClick)
                PlayerButton(data.blue, onClick = onButtonClick)
                PlayerButton(data.pink, onClick = onButtonClick)
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        LazyRow(
            modifier = Modifier
                .height(200.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(uiState.playerCharacters) {card ->
                CharacterCard(
                    card,
                    onConfirmClick = onConfirmClick,
                    onNextButtonClick = onNextButtonClick
                )
            }
        }
    }
}

@Composable
fun PlayerButton(
    color: Color = Color.Black,
    onClick: (ImageCard) -> Unit = {}
) {
    var selected by remember { mutableStateOf(false) }
    val borderWidth = if (selected) 4 else -1
    val character = data.loadCharacter(color)

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
        border = BorderStroke(borderWidth.dp, Color.White),
        shape = RectangleShape
        ) {}
}


@Composable
fun CharacterCard(
    card: ImageCard,
    onConfirmClick: (ImageCard) -> Unit,
    onNextButtonClick: () -> Unit
) {
    val openAlertDialog = remember { mutableStateOf(false) }

    when {
        openAlertDialog.value -> {
            ConfirmationDialog(
                onDismissRequest = { openAlertDialog.value = false },
                onConfirmation = {
                    openAlertDialog.value = false
                    onConfirmClick(card)
                    onNextButtonClick()
                },
                character = card
            )
        }
    }

    IconButton(
        modifier = Modifier
            .padding(8.dp)
            .width(110.dp)
            .height(160.dp),
        onClick = { openAlertDialog.value = true }
    ) {
        Image(
            painter = painterResource(card.drawableResourceId),
            contentDescription = stringResource(card.stringResourceId),
            modifier = Modifier
                .width(110.dp)
                .height(260.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun ConfirmationDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    character: ImageCard
) {
    AlertDialog(
        icon = {
               Image(
                   modifier = Modifier
                       .width(165.dp)
                       .height(240.dp),
                   painter = painterResource(character.drawableResourceId),
                   contentDescription = stringResource(character.stringResourceId)
               )
        },
        title = {
            Text("Are you sure you want to play as ${
                stringResource(character.stringResourceId)
            }?")
               },
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            TextButton(onClick = onConfirmation) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text("Cancel")
            }
        }
    )
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
            playerCharacters = data.loadCharacters()
        )
    )
}