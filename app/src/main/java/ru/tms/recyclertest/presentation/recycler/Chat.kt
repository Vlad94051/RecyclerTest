package ru.tms.recyclertest.presentation.recycler

import androidx.annotation.DrawableRes

data class Chat(
    val title: String,
    val subtitle: String,
    @DrawableRes val iconId: Int
)
