package com.financords.gamefetcher.di.application

import com.financords.data.api.ServiceApi
import com.financords.data.mapper.GameMapper
import com.financords.data.repository.GameRepositoryImpl
import com.financords.domain.repository.GameRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideGameRepository(
        serviceApi: ServiceApi,
        mapper: GameMapper
    ) : GameRepository {
        return GameRepositoryImpl(serviceApi, mapper)
    }
}