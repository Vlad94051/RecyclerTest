package ru.tms.recyclertest.data

import android.widget.LinearLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.tms.recyclertest.R
import ru.tms.recyclertest.domain.ChatInteractor
import ru.tms.recyclertest.presentation.recycler.Chat

class DataSource: ChatInteractor {
    private val list: List<Chat> = listOf(
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
        ),
        Chat(
            "122",
            "5",
            R.drawable.ic_launcher_foreground
        ),
        Chat(
            "122",
            "5",
            R.drawable.ic_launcher_foreground
        ),
        Chat(
            "122",
            "16663",
            R.drawable.ic_launcher_foreground
        )
    )

    private val orientation: DataOrientation = DataOrientation.VERTICAL

    override suspend fun loadMessages(): List<Chat> {
        withContext(Dispatchers.IO) {
            // TODO work with db
        }
        return list
    }

    override fun loadOrientation(): Int {
        return when (orientation) {
            DataOrientation.HORIZONTAL -> LinearLayout.HORIZONTAL
            else -> LinearLayout.VERTICAL
        }
    }
}