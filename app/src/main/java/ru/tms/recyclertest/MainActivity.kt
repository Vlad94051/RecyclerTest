package ru.tms.recyclertest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.tms.recyclertest.recycler.Chat
import ru.tms.recyclertest.recycler.ChatAdapter

class MainActivity : AppCompatActivity() {
    private val chatAdapter by lazy { ChatAdapter() }

    private val chatItems: List<Chat> = initChatList() // Этих данных тут быть не должно. Выносить их в отдельный объект, как на прошлом уроке

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initRecycler()
    }

    override fun onResume() {
        super.onResume()
        chatAdapter.submitList(chatItems)
    }

    private fun initRecycler() {
        recyclerChat.adapter = chatAdapter

        chatAdapter.setOnItemClickListener { chat ->
            Toast.makeText(this, chat.title, Toast.LENGTH_LONG).show()
        }
    }

    private fun initChatList(): List<Chat> {
        val list = mutableListOf<Chat>()

        for (i in 0 until 10) {
            list.add(
                Chat(
                    title = "Title$i",
                    subtitle = "Subtitle$i",
                    iconId = R.drawable.ic_launcher_foreground
                )
            )
        }
        return list
    }
}