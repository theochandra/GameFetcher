package com.financords.gamefetcher.di.screen.game

import com.financords.domain.usecase.GetGamesUseCase
import com.financords.gamefetcher.presentation.game.GameViewModelFactory
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