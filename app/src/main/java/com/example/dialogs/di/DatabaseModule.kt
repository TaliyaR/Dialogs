package com.example.dialogs.di

import android.content.Context
import androidx.room.Room
import com.example.dialogs.db.AppDatabase
import com.example.dialogs.db.dao.MessageDao
import com.example.dialogs.model.MessageInteractor
import com.example.dialogs.model.MessageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideMessageDao(database: AppDatabase): MessageDao {
        return database.messageDao
    }

    @Provides
    @Singleton
    fun provideMessageRepository(messageDao: MessageDao) = MessageRepository(messageDao)

    @Provides
    @Singleton
    fun provideMessageInteractor(messageRepository: MessageRepository) =
        MessageInteractor(messageRepository)

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ): AppDatabase = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java,
        "dbMy.db"
    ).build()
}
