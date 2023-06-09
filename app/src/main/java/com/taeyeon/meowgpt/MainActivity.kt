package com.taeyeon.meowgpt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.remember
import com.taeyeon.meowgpt.ui.MainScreen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val meowState = rememberMeowState()
            val meowViewModel = remember { MeowViewModel(state =  meowState) }
            MainScreen(meowViewModel = meowViewModel)
        }
    }
}
