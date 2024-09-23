package com.ironan.lamun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeRuntimeApi
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ironan.lamun.ui.theme.LamunTheme
import com.ironan.lamun.viewmodel.CandleViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeRuntimeApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LamunTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val candleViewModel = viewModel<CandleViewModel>()
                    LamunApp(candleViewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LamunApp(candleViewModel: CandleViewModel) {
    val candleList = candleViewModel.candleList.collectAsState().value

    HomeScreen(candles = candleList,
        onRemoveCandle = { candleViewModel.removeCandle(it) },
        onAddCandle = { candleViewModel.addCandle(it) }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LamunTheme {

    }
}