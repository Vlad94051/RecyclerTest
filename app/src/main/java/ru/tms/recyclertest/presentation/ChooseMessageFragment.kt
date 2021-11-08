package ru.tms.recyclertest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_choose_message.*
import ru.tms.recyclertest.R
import ru.tms.recyclertest.presentation.recycler.Chat
import ru.tms.recyclertest.presentation.recycler.ChatAdapter

class ChooseMessageFragment(private val listener: (Chat) -> Unit) : BottomSheetDialogFragment() {
    companion object {
        fun newInstance(listener: (Chat) -> Unit) =
            ChooseMessageFragment(listener)

        const val TAG = "12"
    }

    private val adapter by lazy { ChatAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_choose_message, container, false
    )

    override fun onResume() {
        super.onResume()
        list.adapter = adapter

       // adapter.submitList()

        adapter.setOnItemClickListener { chatItem ->
            listener.invoke(chatItem)
            dismiss()
        }
    }
}