package com.example.dialogs.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val message: String,
    @Embedded(prefix = "chat_")
    val chat: Chat
)
