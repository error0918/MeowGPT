@file:OptIn(ExperimentalMaterial3Api::class)

package com.taeyeon.meowgpt.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taeyeon.meowgpt.theme.SetSystemBarColor
import com.taeyeon.meowgpt.theme.gptColorScheme

@Composable
fun MainScreen() {
    SetSystemBarColor(
        statusBarColor = MaterialTheme.gptColorScheme.topBar,
        statusBarDarkIcons = false,
        navigationBarColor = MaterialTheme.gptColorScheme.surface,
        navigationBarDarkIcons = !isSystemInDarkTheme()
    )

    Scaffold(
        topBar = { TopAppBar() },
        bottomBar = { BottomAppBar() },
        snackbarHost = {},
        floatingActionButton = {},
        floatingActionButtonPosition = FabPosition.End,
        containerColor = MaterialTheme.gptColorScheme.surface,
        contentColor = MaterialTheme.gptColorScheme.onSurface,
        content = {
            Box(
               modifier = Modifier.padding(it)
            )
        }
    )
}