package com.example.dialogs.ui.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dialogs.R
import com.example.dialogs.entities.Message
import kotlinx.android.synthetic.main.send_message.view.*

class SendMessageHolder(
    override val containerView: View,
    private val viewType: Int,
) : MessageHolder<Message>(containerView) {

    override fun bind(item: Message) {
        containerView.tv_message_send.text = item.message
    }

    companion object {

        fun create(parent: ViewGroup, viewType: Int) =
            SendMessageHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.send_message, parent, false),
                viewType
            )
    }
}
