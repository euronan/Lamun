package com.ironan.lamun

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ironan.lamun.data.CandlesData
import com.ironan.lamun.model.Candle

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalComposeUiApi
@Composable
fun HomeScreen (
    candles: List<Candle>,
    onAddCandle: (Candle) -> Unit,
    onRemoveCandle: (Candle) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            modifier = Modifier.shadow(
                elevation = 4.dp
            ),
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}



@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(candles = CandlesData().loadCandles(), onAddCandle = {}, onRemoveCandle = {})
}