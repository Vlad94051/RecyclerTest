package ru.tms.recyclertest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
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
    private val viewModel by lazy { ChooseMessageViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_choose_message, container, false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserves()
        list.adapter = adapter

        adapter.setOnItemClickListener { chatItem ->
            listener.invoke(chatItem)
            dismiss()
        }
    }

    private fun initObserves() {
        viewModel.messages.observe(viewLifecycleOwner) { messages ->
            adapter.submitList(messages)
        }

        viewModel.listOrientation.observe(viewLifecycleOwner) { orientation ->
            list.layoutManager = LinearLayoutManager(requireContext(), orientation, false)
        }
    }
}