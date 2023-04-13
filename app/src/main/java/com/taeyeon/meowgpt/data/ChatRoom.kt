package com.taeyeon.meowgpt.data

import androidx.compose.runtime.mutableStateListOf

class ChatRoom(
    val title: String
) {
    val chatList = mutableStateListOf<Chat>()
}