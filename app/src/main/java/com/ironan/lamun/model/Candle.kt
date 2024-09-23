package com.ironan.lamun.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date

@Entity(tableName = "candles_tbl")
data class Candle(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val description: String,
    val price: Double? = null,
    val weight: Double? = null,
    val addDate: Date = Date.from(Instant.now()),
)