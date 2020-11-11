package com.example.dialogs.ui.rv

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class MessageHolder<T>(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    abstract fun bind(item: T)
}
