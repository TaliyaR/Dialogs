package com.example.dialogs.presentation

import com.example.dialogs.entities.Message
import moxy.MvpView

interface DialogView : MvpView {

    fun setMessageList(list: List<Message>)
}
