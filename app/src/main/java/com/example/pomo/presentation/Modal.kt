package com.example.pomo.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


val categoryColor = Color.White
@Composable
fun CategoryLabel(){
    OutlinedButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(top = 16.dp, start = 2.dp, end = 2.dp, bottom = 2.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = categoryColor,
            contentColor = Color.Gray
        )
        ) {
        Text("Category")
    }
}
@Composable
fun StartFocus() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .align(Alignment.End)
        ) {
            ElevatedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.White
                )
            ) {
                Text("Focus !")
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Modal () {

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(true) }

        // Screen content
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                // Sheet content
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.End)
                    ) {
                        repeat(3) {
                            CategoryLabel()
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                   StartFocus()
            }
        }
    }
}

