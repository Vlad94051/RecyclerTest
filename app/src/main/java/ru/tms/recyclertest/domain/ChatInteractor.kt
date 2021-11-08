package ru.tms.recyclertest.domain

import ru.tms.recyclertest.presentation.recycler.Chat

interface ChatInteractor {
    fun loadMessages(): List<Chat>

    fun loadOrientation(): Int
}