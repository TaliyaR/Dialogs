package com.example.dialogs.ui.chat.rv

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dialogs.entities.Message
import kotlinx.android.extensions.LayoutContainer

abstract class MessageHolder<T>(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    abstract fun bind(item: Message)
}
