package ru.tms.recyclertest.presentation

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.tms.recyclertest.R
import ru.tms.recyclertest.presentation.recycler.Chat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private val viewModel by lazy { ChooseMessageViewModel() }

    override fun onStart() {
        super.onStart()
        initRecycler()
    }


    private fun initRecycler() {
        inputField.setOnClickListener {
            val fr = ChooseMessageFragment.newInstance { chatItem ->
                inputField.text = Editable.Factory.getInstance().newEditable(chatItem.subtitle)
            }

            fr.show(supportFragmentManager, ChooseMessageFragment.TAG)
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