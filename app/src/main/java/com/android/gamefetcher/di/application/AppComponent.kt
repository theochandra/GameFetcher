package com.android.gamefetcher.di.application

import com.android.gamefetcher.di.screen.game.GameSubComponent
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