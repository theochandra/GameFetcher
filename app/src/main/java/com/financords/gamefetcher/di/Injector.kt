package com.financords.gamefetcher.di

import com.financords.gamefetcher.di.screen.game.GameSubComponent

interface Injector {

    fun createGameSubComponent(): GameSubComponent

}