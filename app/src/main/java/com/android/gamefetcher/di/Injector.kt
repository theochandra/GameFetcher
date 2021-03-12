package com.android.gamefetcher.di

import com.android.gamefetcher.di.screen.game.GameSubComponent

interface Injector {

    fun createGameSubComponent(): GameSubComponent

}