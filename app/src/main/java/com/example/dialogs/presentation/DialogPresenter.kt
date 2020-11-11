package com.example.dialogs.presentation

import moxy.MvpPresenter

class DialogPresenter : MvpPresenter<DialogView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun onSentMessageClick(text: String){}


}