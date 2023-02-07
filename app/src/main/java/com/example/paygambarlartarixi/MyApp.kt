package uz.savdogar.mydatabase

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.example.paygambarlartarixi.room.appModule
import com.example.paygambarlartarixi.room.viewModule

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