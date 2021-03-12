package com.android.gamefetcher.di.screen.game

import com.android.domain.usecase.GetGamesUseCase
import com.android.gamefetcher.presentation.game.GameViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GameModule {

    @GameScope
    @Provides
    fun provideGameViewModelFactory(
        useCase: GetGamesUseCase
    ) : GameViewModelFactory {
        return GameViewModelFactory(useCase)
    }

}