package com.example.dialogs.model

import javax.inject.Inject

class MessageInteractor @Inject constructor(
    private val messageRepository: MessageRepository
) {
    fun addMessage(string: String) {
        messageRepository.addMessage(string)
    }

    fun getListOfMessageByChat(chatId: Int) = messageRepository.getListOfMessageByChat(chatId)
}
