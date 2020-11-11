package com.example.dialogs.ui.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dialogs.entities.Message

class MessageListAdapter(
    private var data: List<Message> = emptyList()
) : RecyclerView.Adapter<MessageHolder<*>>() {

    private val VIEW_TYPE_MESSAGE_SENT = 0
    private val VIEW_TYPE_MESSAGE_RECEIVED = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder<*> {
        return when (viewType) {
            VIEW_TYPE_MESSAGE_SENT -> SendMessageHolder.create(parent, viewType)
            VIEW_TYPE_MESSAGE_RECEIVED -> ReceiveMessageHolder.create(parent, viewType)
            else -> throw java.lang.IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: MessageHolder<*>, position: Int) {
        val item = data[position]
        when (holder) {
            is SendMessageHolder -> holder.bind(item)
            is ReceiveMessageHolder -> holder.bind(item)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int {
        val message = data.get(position)
        if (message.chat.sender.id == 1) {
            return VIEW_TYPE_MESSAGE_SENT
        } else {
            return VIEW_TYPE_MESSAGE_RECEIVED
        }
    }
}
