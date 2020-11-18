package com.example.dialogs.model

import com.example.dialogs.db.dao.MessageDao
import com.example.dialogs.entities.Chat
import com.example.dialogs.entities.Message
import com.example.dialogs.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MessageRepository @Inject constructor(
    private val messageDao: MessageDao
) {

    private var currentUser = User(1, "Mary")
    private var recipientUser = User(2, "Kate")
    private var chat = Chat(1, recipientUser, currentUser)

    suspend fun addMessage(str: String) {
        withContext(Dispatchers.IO) {
            var message = Message(null, str, chat)
            messageDao.addMessage(message)
        }
    }

    suspend fun getListOfMessageByChat(chatId: Int): List<Message> =
        withContext(Dispatchers.IO) {
            messageDao.getListOfMessageByChatId(chatId)
        }
}
