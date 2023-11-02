package com.example.cluehack.data

import com.example.cluehack.R
import com.example.cluehack.model.Card

class DataSource() {
    fun loadCharacters(): List<Card> {
        return listOf<Card>(
            Card(R.string.miss_scarlett, R.drawable.missscarlett),
            Card(R.string.reverend_green, R.drawable.reverendgreen),
            Card(R.string.colonel_mustard, R.drawable.colonelmustard),
            Card(R.string.professor_plum, R.drawable.professorplum),
            Card(R.string.mrs_peacock, R.drawable.mrspeacock),
            Card(R.string.mrs_white, R.drawable.mrswhite)
        )
    }

    fun loadWeapons(): List<Card> {
        return listOf<Card>(
            Card(R.string.candlestick, R.drawable.candlestick),
            Card(R.string.dagger, R.drawable.dagger),
            Card(R.string.lead_piping, R.drawable.leadpiping),
            Card(R.string.revolver, R.drawable.revolver),
            Card(R.string.rope, R.drawable.rope),
            Card(R.string.spanner, R.drawable.spanner)
        )
    }

    fun loadRooms(): List<Card> {
        return listOf<Card>(
            Card(R.string.kitchen, R.drawable.kitchen),
            Card(R.string.drawing_room, R.drawable.drawingroom),
            Card(R.string.conservatory, R.drawable.conservatory),
            Card(R.string.dining_room, R.drawable.diningroom),
            Card(R.string.gazebo, R.drawable.gazebo),
            Card(R.string.trophy_room, R.drawable.trophyroom),
            Card(R.string.studio, R.drawable.studio),
            Card(R.string.library, R.drawable.library),
            Card(R.string.billiard_room, R.drawable.billiardroom)
        )
    }
}
