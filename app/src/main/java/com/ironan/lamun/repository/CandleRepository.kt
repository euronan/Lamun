package com.ironan.lamun.repository

import com.ironan.lamun.data.CandleDatabaseDao
import com.ironan.lamun.model.Candle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CandleRepository @Inject constructor(private val candleDatabaseDao: CandleDatabaseDao) {
    suspend fun addCandle(candle: Candle) = candleDatabaseDao.insert(candle)
    suspend fun updateCandle(candle: Candle) = candleDatabaseDao.update(candle)
    suspend fun deleteCandle(candle: Candle) = candleDatabaseDao.deleteCandle(candle)
    suspend fun deleteAllCandles() = candleDatabaseDao.deleteAll()
    fun getAllCandles(): Flow<List<Candle>> = candleDatabaseDao.getCandles().flowOn(Dispatchers.IO).conflate()
}