package ru.tms.recyclertest.data

import ru.tms.recyclertest.domain.ChatInteractor
import ru.tms.recyclertest.presentation.recycler.Chat

class ServerSource : ChatInteractor {
    override suspend fun loadMessages(): List<Chat> {
        TODO("Not yet implemented")
    }

    override fun loadOrientation(): Int {
        TODO("Not yet implemented")
    }}