package com.financords.gamefetcher.base

import android.app.Application
import com.financords.gamefetcher.di.Injector
import com.financords.gamefetcher.di.application.AppComponent
import com.financords.gamefetcher.di.application.AppModule
import com.financords.gamefetcher.di.application.DaggerAppComponent
import com.financords.gamefetcher.di.screen.game.GameSubComponent

class BaseApplication : Application(), Injector {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }

    override fun createGameSubComponent(): GameSubComponent {
        return appComponent.gameSubComponent().create()
    }

}