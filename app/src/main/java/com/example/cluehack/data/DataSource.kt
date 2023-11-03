package com.example.cluehack.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.cluehack.R
import com.example.cluehack.model.ImageCard

class DataSource() {
    private val missScarlett = ImageCard(R.string.miss_scarlett, R.drawable.missscarlett, Color.Red)
    private val reverendGreen = ImageCard(R.string.reverend_green, R.drawable.reverendgreen, Color.Green)
    private val colonelMustard = ImageCard(R.string.colonel_mustard, R.drawable.colonelmustard, Color.Yellow)
    private val professorPlum = ImageCard(R.string.professor_plum, R.drawable.professorplum, Color.Magenta)
    private val mrsPeacock = ImageCard(R.string.mrs_peacock, R.drawable.mrspeacock, Color.Blue)
    private val mrsWhite = ImageCard(R.string.mrs_white, R.drawable.mrswhite, Color.White)

    private val candleStick = ImageCard(R.string.candlestick, R.drawable.candlestick)
    private val dagger = ImageCard(R.string.dagger, R.drawable.dagger)
    private val leadPiping = ImageCard(R.string.lead_piping, R.drawable.leadpiping)
    private val revolver = ImageCard(R.string.revolver, R.drawable.revolver)
    private val rope = ImageCard(R.string.rope, R.drawable.rope)
    private val spanner = ImageCard(R.string.spanner, R.drawable.spanner)

    private val kitchen = ImageCard(R.string.kitchen, R.drawable.kitchen)
    private val drawingRoom= ImageCard(R.string.drawing_room, R.drawable.drawingroom)
    private val conservatory = ImageCard(R.string.conservatory, R.drawable.conservatory)
    private val diningRoom = ImageCard(R.string.dining_room, R.drawable.diningroom)
    private val gazebo = ImageCard(R.string.gazebo, R.drawable.gazebo)
    private val trophyRoom = ImageCard(R.string.trophy_room, R.drawable.trophyroom)
    private val studio = ImageCard(R.string.studio, R.drawable.studio)
    private val library = ImageCard(R.string.library, R.drawable.library)
    private val billiardRoom = ImageCard(R.string.billiard_room, R.drawable.billiardroom)

    private val selectedCharacters = mutableListOf<ImageCard>()


//    fun load(@StringRes stringId: Int): ImageCard {
//        when(stringId) {
//            R.string.gazebo -> return gazebo
//            R.string.trophy_room -> return trophyRoom
//            R.string.library -> return library
//            R.string.studio -> return studio
//            R.string.billiard_room -> return billiardRoom
//            R.string.dining_room -> return diningRoom
//            R.string.conservatory -> return conservatory
//            R.string.drawing_room -> return drawingRoom
//            R.string.kitchen -> return kitchen
//
//            R.string.candlestick -> return candleStick
//            R.string.lead_piping -> return leadPiping
//            R.string.dagger -> return dagger
//            R.string.revolver -> return revolver
//            R.string.rope -> return rope
//            R.string.spanner -> return spanner
//
//            R.string.miss_scarlett -> return missScarlett
//            R.string.reverend_green -> return reverendGreen
//            R.string.colonel_mustard -> return colonelMustard
//            R.string.professor_plum -> return professorPlum
//            R.string.mrs_white -> return mrsWhite
//            else -> return mrsPeacock
//        }
//    }

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

    fun addCharacter(character: ImageCard) {
        if (!selectedCharacters.contains(character)) {
            selectedCharacters.add(character)
        }
    }

    fun removeCharacter(character: ImageCard) {
        if (selectedCharacters.contains(character)) {
            selectedCharacters.remove(character)
        }
    }

    fun getSelectedCharacters(): List<ImageCard> {
        return selectedCharacters
    }
}
