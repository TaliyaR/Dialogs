package com.example.dialogs.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Chat::class,
        parentColumns = ["id"],
        childColumns = ["chatId"]
    )]
)
data class Message(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val message: String,
    val chatId: Int
)
