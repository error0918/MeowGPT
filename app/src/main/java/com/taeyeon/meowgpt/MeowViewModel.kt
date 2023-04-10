package com.taeyeon.meowgpt

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MeowViewModel: ViewModel() {
    var prompt by mutableStateOf("")

    var darkMode by mutableStateOf(false)
    var isSideBarOpened by mutableStateOf(false)
}