package com.example.cluehack.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color

data class ImageCard (
    @StringRes val stringResourceId: Int,
    @DrawableRes val drawableResourceId: Int,
    val color: Color = Color.Black
)