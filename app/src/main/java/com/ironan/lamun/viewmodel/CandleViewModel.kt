package com.ironan.lamun.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ironan.lamun.data.CandlesData
import com.ironan.lamun.model.Candle
import com.ironan.lamun.repository.CandleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CandleViewModel @Inject constructor(private val candleRepository: CandleRepository) : ViewModel() {

    private val _candleList = MutableStateFlow<List<Candle>>(emptyList())
    val candleList = _candleList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            candleRepository.getAllCandles().distinctUntilChanged()
                .collect { listOfCandles ->
                    if (listOfCandles.isEmpty()) {
                        //SHOW EMPTY SCREEN
                        return@collect
                    }
                    
                    _candleList.value = listOfCandles
                    
                }

        }
    }

    fun addCandle(note: Candle) = viewModelScope.launch { candleRepository.addCandle(note) }
    fun updateCandle(note: Candle) = viewModelScope.launch { candleRepository.updateCandle(note) }
    fun removeCandle(note: Candle) = viewModelScope.launch { candleRepository.deleteCandle(note) }
}