package com.example.dialogs.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Chat(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @Embedded
    val receiver: User,
    @Embedded
    val sender: User
)