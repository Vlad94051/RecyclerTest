package ru.tms.recyclertest.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
import ru.tms.recyclertest.R

class ChatViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun from(parent: ViewGroup): ChatViewHolder {
            return ChatViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_layout, parent, false)
            )
        }
    }

    private val titleTextView: TextView by lazy { itemView.title }
    private val subtitleTextView: TextView by lazy { itemView.subtitle }
    private val iconImageView: ImageView by lazy { itemView.icon }

    private var itemClickListener : ((Chat) -> Unit)? = null

    fun bindView(item: Chat) {
        titleTextView.text = item.title
        subtitleTextView.text = item.subtitle
        iconImageView.setImageResource(item.iconId)

        itemView.setOnClickListener {
            itemClickListener?.invoke(item)
        }
    }

    fun setItemClickListener(listener: ((Chat) -> Unit)) {
        itemClickListener = listener
    }
}