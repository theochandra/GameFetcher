package com.android.gamefetcher.di.application

import com.android.data.api.ServiceApi
import com.android.data.mapper.GameMapper
import com.android.data.repository.GameRepositoryImpl
import com.android.domain.repository.GameRepository
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