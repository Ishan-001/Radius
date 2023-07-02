package com.example.radius.data.persistence

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun providesRealm(): Realm = Realm.getDefaultInstance()

    @Provides
    @Singleton
    fun providesCurrentTime(): Long = System.currentTimeMillis()
}