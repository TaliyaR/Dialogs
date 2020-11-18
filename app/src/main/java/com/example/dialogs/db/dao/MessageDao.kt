package com.example.dialogs.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dialogs.entities.Message

@Dao
interface MessageDao {

    @Insert
    suspend fun addMessage(message: Message)

    @Query("SELECT * FROM Message WHERE chat_id = :chatId")
    suspend fun getListOfMessageByChatId(chatId: Int): List<Message>
}
