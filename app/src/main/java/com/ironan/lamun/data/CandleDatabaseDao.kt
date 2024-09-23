package com.ironan.lamun.data

import androidx.room.*
import com.ironan.lamun.model.Candle
import kotlinx.coroutines.flow.Flow

@Dao
interface CandleDatabaseDao {

    @Query("SELECT * from candles_tbl")
    fun getCandles():
            Flow<List<Candle>>

    @Query("SELECT * from candles_tbl where id =:id")
    suspend fun getCandleById(id: String): Candle

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Candle)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Candle)

    @Query("DELETE from candles_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteCandle(candle: Candle)
}