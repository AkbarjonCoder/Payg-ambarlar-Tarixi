package com.tarix.paygambarlartarixi

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.tarix.paygambarlartarixi.room.appModule
import com.tarix.paygambarlartarixi.room.viewModule

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(listOf(appModule, viewModule))
        }

    }

}