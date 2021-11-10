package ru.tms.recyclertest.domain

import ru.tms.recyclertest.presentation.recycler.Chat

interface ChatInteractor {
   suspend fun loadMessages(): List<Chat>

   fun loadOrientation(): Int
}