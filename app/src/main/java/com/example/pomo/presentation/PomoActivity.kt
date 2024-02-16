package com.example.pomo.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pomo.ui.theme.PomoTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class PomoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PomoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Modal()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(onFabClick: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onFabClick,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Row(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    Text("Commit")
                }
            }
        },
        content = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Log",
                        style = MaterialTheme.typography.headlineMedium)
                }
        }
        }
    )
}

@Composable
fun FocusScreen() {

    var seconds by remember { mutableStateOf(0) }
    var minutes by remember { mutableStateOf(24) }

    LaunchedEffect(Unit) {
        val timer = object : CountDownTimer(minutes * 60 * 1000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                seconds = (millisUntilFinished / 1000L).toInt() % 60
            }

            override fun onFinish() {
                // タイマー終了時の処理
            }
        }
        timer.start()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "%02d:%02d".format(minutes, seconds),
            modifier = Modifier.align(Alignment.Center),
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            )
    }

}


@Preview(showBackground = true)
@Composable
fun PomoPreview() {
    PomoTheme {
    }
}