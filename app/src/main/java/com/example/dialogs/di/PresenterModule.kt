package com.example.dialogs.di

import com.example.dialogs.model.MessageInteractor
import com.example.dialogs.presentation.DialogPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object PresenterModule {

    @Provides
    fun provideDialogPresenter(messageInteractor: MessageInteractor): DialogPresenter {
        return DialogPresenter(messageInteractor)
    }
}