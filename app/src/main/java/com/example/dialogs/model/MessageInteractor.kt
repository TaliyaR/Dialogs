package com.example.dialogs.model

import javax.inject.Inject

class MessageInteractor @Inject constructor(
    private val messageRepository: MessageRepository
) {
    suspend fun addMessage(string: String) {
        messageRepository.addMessage(string)
    }

    suspend fun getListOfMessageByChat(chatId: Int) =
        messageRepository.getListOfMessageByChat(chatId)
}
