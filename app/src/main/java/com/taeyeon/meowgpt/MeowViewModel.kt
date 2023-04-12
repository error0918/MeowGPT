package com.taeyeon.meowgpt

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MeowViewModel(
    val state: MeowState
): ViewModel() {
    var prompt by mutableStateOf("")
    var settingsDialog by mutableStateOf(false)
    var darkMode by mutableStateOf(false)
}