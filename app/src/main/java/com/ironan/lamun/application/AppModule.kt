package com.ironan.lamun.application

import android.content.Context
import androidx.room.Room
import com.ironan.lamun.data.CandleDatabase
import com.ironan.lamun.data.CandleDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCandleDao(candleDatabase: CandleDatabase): CandleDatabaseDao
            = candleDatabase.candleDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): CandleDatabase
            = Room.databaseBuilder(
        context,
        CandleDatabase::class.java,
        "candles_db")
        .fallbackToDestructiveMigration()
        .build()
}