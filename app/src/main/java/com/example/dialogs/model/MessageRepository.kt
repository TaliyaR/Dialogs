package com.example.dialogs.model

import com.example.dialogs.db.dao.MessageDao
import com.example.dialogs.entities.Chat
import com.example.dialogs.entities.Message
import com.example.dialogs.entities.User
import javax.inject.Inject

class MessageRepository @Inject constructor(
    private val messageDao: MessageDao
) {

    private var currentUser = User(1, "Kate")
    private var recipientUser = User(2, "Mary")
    private var chat = Chat(1, currentUser, recipientUser)

    fun addMessage(str: String) {
        var message = Message(null, str, chat)
        messageDao.addMessage(message)
    }

    fun getListOfMessageByChat(chatId: Int): List<Message> =
        messageDao.getListOfMessageByChatId(chatId)
}
