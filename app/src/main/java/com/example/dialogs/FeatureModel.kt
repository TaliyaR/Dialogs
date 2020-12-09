package com.example.dialogs

import dagger.Provides
import javax.inject.Singleton


class FeatureModel {

    val chatScreenEnabled = false

    fun isChatScreenIsEnabled(): Boolean = chatScreenEnabled
}