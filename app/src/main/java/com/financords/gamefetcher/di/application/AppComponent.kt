package com.financords.gamefetcher.di.application

import com.financords.gamefetcher.di.screen.game.GameSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    RepositoryModule::class
])
interface AppComponent {

    fun gameSubComponent(): GameSubComponent.Factory

}