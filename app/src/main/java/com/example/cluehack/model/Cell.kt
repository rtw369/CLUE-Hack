package com.example.cluehack.model

data class Cell (
    // Holds the player's information if it's occupied with one, is null if not.
    val player: ImageCard? = null,

    // If isRoom, it may hold a player but a player cannot move there.
    val isRoom: Boolean = false,

    // If isEmpty, it may not hold a player and a player cannot move there.
    val isEmpty: Boolean = false,
)