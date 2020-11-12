package com.example.dialogs.presentation

import com.example.dialogs.entities.Chat
import com.example.dialogs.entities.Message
import com.example.dialogs.entities.User
import com.example.dialogs.model.MessageInteractor
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class DialogPresenter @Inject constructor(
    private val messageInteractor: MessageInteractor
) : MvpPresenter<DialogView>() {

    private var chatId = 1

    private var currentUser = User(0, "Kate")
    private var recipientUser = User(1, "Mary")
    private var chat = Chat(1, currentUser, recipientUser)

    private var listOfMessage: MutableList<Message> = mutableListOf()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
//        updateList()
    }

    fun onSentMessageClick(text: String) {
        var message = Message(null, text, chat)
        listOfMessage.add(message)
        messageInteractor.addMessage(text)
        updateList()
    }

    private fun updateList() {
//        val list = messageInteractor.getListOfMessageByChat(chatId)
//        if (!list.isEmpty()) {
            viewState.setMessageList(listOfMessage)
//        }
    }
}