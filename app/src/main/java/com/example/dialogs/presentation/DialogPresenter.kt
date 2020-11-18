package com.example.dialogs.presentation

import com.example.dialogs.entities.Chat
import com.example.dialogs.entities.Message
import com.example.dialogs.entities.User
import com.example.dialogs.model.MessageInteractor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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
        GlobalScope.launch {
            listOfMessage = messageInteractor.getListOfMessageByChat(chatId).toMutableList()
            updateList()
        }
    }

    fun onSentMessageClick(text: String) {
        GlobalScope.launch {
            messageInteractor.addMessage(text)
        }
        listOfMessage.add(Message(null, text, chat))
        updateList()
        viewState.setEditTextEmptyAndScrollList()
    }

    private fun updateList() {
        if (listOfMessage.isNotEmpty()) {
            viewState.setMessageList(listOfMessage)
            viewState.setNullListText(false)
        } else {
            viewState.setNullListText(true)
        }
    }
}