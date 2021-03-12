package com.android.gamefetcher.base

import android.app.Application
import com.android.gamefetcher.di.Injector
import com.android.gamefetcher.di.application.AppComponent
import com.android.gamefetcher.di.application.AppModule
import com.android.gamefetcher.di.application.DaggerAppComponent
import com.android.gamefetcher.di.screen.game.GameSubComponent

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