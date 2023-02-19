package com.tarix.paygambarlartarixi.room

import androidx.room.Room
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java,"room").fallbackToDestructiveMigration().build()
    }

    single {
        get<AppDatabase>().getDao()
    }

}