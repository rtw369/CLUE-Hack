package com.example.cluehack.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Card (
    @StringRes val stringResourceId: Int,
    @DrawableRes val drawableResourceId: Int
)