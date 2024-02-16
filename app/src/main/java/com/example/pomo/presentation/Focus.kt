package com.example.pomo.presentation

import android.os.CountDownTimer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

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
                // タイマー終了時の処理書こうね。画面遷移だよ
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