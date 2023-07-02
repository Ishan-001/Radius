package com.example.radius.data.repository

import com.example.radius.data.network.service.RadiusService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.realm.Realm

@Module
@InstallIn(ViewModelComponent::class)
object LiveRoomRepositoryModule {
    @ViewModelScoped
    @Provides
    fun provideRepository(
        service: RadiusService,
        realm: Realm,
        timestamp: Long
    ): Repository =
        Repository(service, realm, timestamp)
}