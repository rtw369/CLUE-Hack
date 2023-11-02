package com.example.cluehack.viewModel

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StartingScreenView(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PlayerSelectButtons()

        CharacterCardsRow()
    }
}

@Composable
fun PlayerSelectButtons() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ButtonRow(Color.Red, Color.Green, Color.Yellow)
        ButtonRow(Color.Magenta, Color.Blue, Color.White)
    }
}

@Composable
fun ButtonRow(color1: Color, color2: Color, color3: Color) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PlayerButton(color1)
        PlayerButton(color2)
        PlayerButton(color3)
    }
}

@Composable
fun PlayerButton(color: Color = Color.Black) {
    Button(
        modifier = Modifier
            .height(108.dp)
            .width(108.dp)
            .padding(8.dp),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RectangleShape
        ) {

    }
}

@Composable
fun CharacterCardsRow() {

}

@Preview
@Composable
fun StartingScreenViewPreview() {
    StartingScreenView(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    )
}