package com.financords.gamefetcher.di.screen.game

import com.financords.gamefetcher.presentation.game.GameActivity
import dagger.Subcomponent

@GameScope
@Subcomponent(modules = [
    GameModule::class
])
interface GameSubComponent {

    fun inject(gameActivity: GameActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GameSubComponent
    }

}