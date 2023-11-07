package com.example.cluehack.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.cluehack.R
import com.example.cluehack.model.ImageCard

class DataSource() {
    private val missScarlett = ImageCard(R.string.miss_scarlett, R.drawable.miss_scarlett, Color.Red)
    private val reverendGreen = ImageCard(R.string.reverend_green, R.drawable.reverend_green, Color.Green)
    private val colonelMustard = ImageCard(R.string.colonel_mustard, R.drawable.colonel_mustard, Color.Yellow)
    private val professorPlum = ImageCard(R.string.professor_plum, R.drawable.professor_plum, Color.Magenta)
    private val mrsPeacock = ImageCard(R.string.mrs_peacock, R.drawable.mrs_peacock, Color.Blue)
    private val mrsWhite = ImageCard(R.string.dr_orchid, R.drawable.dr_orchid, Color.Magenta)

    private val candleStick = ImageCard(R.string.candlestick, R.drawable.candlestick)
    private val dagger = ImageCard(R.string.dagger, R.drawable.dagger)
    private val leadPiping = ImageCard(R.string.lead_pipe, R.drawable.lead_pipe)
    private val revolver = ImageCard(R.string.revolver, R.drawable.revolver)
    private val rope = ImageCard(R.string.rope, R.drawable.rope)
    private val spanner = ImageCard(R.string.wrench, R.drawable.wrench)

    private val kitchen = ImageCard(R.string.kitchen, R.drawable.kitchen)
    private val drawingRoom= ImageCard(R.string.ballroom, R.drawable.ballroom)
    private val conservatory = ImageCard(R.string.conservatory, R.drawable.conservatory)
    private val diningRoom = ImageCard(R.string.dining_room, R.drawable.dining_room)
    private val gazebo = ImageCard(R.string.hall, R.drawable.hall)
    private val trophyRoom = ImageCard(R.string.lounge, R.drawable.lounge)
    private val studio = ImageCard(R.string.study, R.drawable.study)
    private val library = ImageCard(R.string.library, R.drawable.library)
    private val billiardRoom = ImageCard(R.string.billiard_room, R.drawable.billiard_room)

    fun loadCharacter(color: Color): ImageCard {
        when(color) {
            Color.Red->  return missScarlett
            Color.Green ->  return reverendGreen
            Color.Yellow ->  return colonelMustard
            Color.Magenta ->  return professorPlum
            Color.White ->  return mrsWhite
            else ->  return mrsPeacock
        }
    }

    fun loadCharacters(): List<ImageCard> {
        return listOf<ImageCard>(
            missScarlett,
            reverendGreen,
            colonelMustard,
            professorPlum,
            mrsPeacock,
            mrsWhite
        )
    }

    fun loadWeapons(): List<ImageCard> {
        return listOf<ImageCard>(
            candleStick,
            dagger,
            leadPiping,
            revolver,
            rope,
            spanner
        )
    }

    fun loadRooms(): List<ImageCard> {
        return listOf<ImageCard>(
            kitchen,
            drawingRoom,
            conservatory,
            diningRoom,
            gazebo,
            trophyRoom,
            studio,
            library,
            billiardRoom
        )
    }
}
