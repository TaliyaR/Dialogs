package com.example.dialogs.di

import com.example.dialogs.FeatureModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object FeatureModule {

    @Provides
    fun provideFeatureModel(): FeatureModel {
        return FeatureModel()
    }
}