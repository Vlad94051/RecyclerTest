package ru.tms.recyclertest.data

import ru.tms.recyclertest.R
import ru.tms.recyclertest.presentation.recycler.Chat

object DataSource {
    val list : List<Chat> = listOf(
        Chat(
            "12",
            "13",
            R.drawable.ic_launcher_foreground
        ),
        Chat(
            "125",
            "1345",
            R.drawable.ic_launcher_foreground
        ),
        Chat(
            "122",
            "16663",
            R.drawable.ic_launcher_foreground
        )
    )
}