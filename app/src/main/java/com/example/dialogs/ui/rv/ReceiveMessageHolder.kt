package com.example.dialogs.ui.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dialogs.R
import com.example.dialogs.entities.Message
import kotlinx.android.synthetic.main.received_message.view.*

class ReceiveMessageHolder(
    override val containerView: View,
    private val viewType: Int,
) : MessageHolder<Message>(containerView) {

    override fun bind(item: Message) {
        containerView.tv_message_receive.text = item.message
        containerView.tv_name.text = item.chat.receiver.name
    }

    companion object {

        fun create(parent: ViewGroup, viewType: Int) =
            ReceiveMessageHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.received_message, parent, false),
                viewType
            )
    }
}
