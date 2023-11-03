package com.example.cluehack.data

import com.example.cluehack.R
import com.example.cluehack.model.ImageCard

class DataSource() {
    fun loadCharacters(): List<ImageCard> {
        return listOf<ImageCard>(
            ImageCard(R.string.miss_scarlett, R.drawable.missscarlett),
            ImageCard(R.string.reverend_green, R.drawable.reverendgreen),
            ImageCard(R.string.colonel_mustard, R.drawable.colonelmustard),
            ImageCard(R.string.professor_plum, R.drawable.professorplum),
            ImageCard(R.string.mrs_peacock, R.drawable.mrspeacock),
            ImageCard(R.string.mrs_white, R.drawable.mrswhite)
        )
    }

    fun loadWeapons(): List<ImageCard> {
        return listOf<ImageCard>(
            ImageCard(R.string.candlestick, R.drawable.candlestick),
            ImageCard(R.string.dagger, R.drawable.dagger),
            ImageCard(R.string.lead_piping, R.drawable.leadpiping),
            ImageCard(R.string.revolver, R.drawable.revolver),
            ImageCard(R.string.rope, R.drawable.rope),
            ImageCard(R.string.spanner, R.drawable.spanner)
        )
    }

    fun loadRooms(): List<ImageCard> {
        return listOf<ImageCard>(
            ImageCard(R.string.kitchen, R.drawable.kitchen),
            ImageCard(R.string.drawing_room, R.drawable.drawingroom),
            ImageCard(R.string.conservatory, R.drawable.conservatory),
            ImageCard(R.string.dining_room, R.drawable.diningroom),
            ImageCard(R.string.gazebo, R.drawable.gazebo),
            ImageCard(R.string.trophy_room, R.drawable.trophyroom),
            ImageCard(R.string.studio, R.drawable.studio),
            ImageCard(R.string.library, R.drawable.library),
            ImageCard(R.string.billiard_room, R.drawable.billiardroom)
        )
    }
}
