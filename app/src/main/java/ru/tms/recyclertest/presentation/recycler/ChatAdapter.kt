package ru.tms.recyclertest.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter : RecyclerView.Adapter<ChatViewHolder>() {

    private var items: List<Chat> = mutableListOf()

    private var itemClickListener: ((Chat) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val viewHolder = ChatViewHolder.from(parent)

        viewHolder.setItemClickListener { chat ->
            itemClickListener?.invoke(chat)
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount() = items.size

    fun submitList(data: List<Chat>) {
        items = data
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (Chat) -> Unit) {
        itemClickListener = listener
    }
}