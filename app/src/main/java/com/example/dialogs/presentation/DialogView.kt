package com.example.dialogs.presentation

import com.example.dialogs.entities.Message
import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface DialogView : MvpView {

    @Skip
    fun setMessageList(list: List<Message>)

    @Skip
    fun setNullListText(boolean: Boolean)

    @Skip
    fun setEditTextEmptyAndScrollList()
}
