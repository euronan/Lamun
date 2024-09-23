package com.ironan.lamun.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ironan.lamun.model.Candle

@Database(entities = [Candle::class],
    version = 1,
    exportSchema = false
)

abstract class CandleDatabase: RoomDatabase() {
    abstract fun candleDao(): CandleDatabaseDao
}