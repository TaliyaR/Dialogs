package com.example.dialogs.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dialogs.db.dao.MessageDao
import com.example.dialogs.entities.Chat
import com.example.dialogs.entities.Message
import com.example.dialogs.entities.User

@Database(entities = [Message::class, Chat::class, User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val messageDao: MessageDao
}
