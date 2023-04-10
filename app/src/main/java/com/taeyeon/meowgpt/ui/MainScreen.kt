package com.taeyeon.meowgpt.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taeyeon.meowgpt.MeowViewModel
import com.taeyeon.meowgpt.theme.MeowGPTTheme
import com.taeyeon.meowgpt.theme.SetSystemBarColor
import com.taeyeon.meowgpt.theme.gptColorScheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(meowViewModel: MeowViewModel = MeowViewModel()) {
    MeowGPTTheme(
        darkTheme = meowViewModel.darkMode
    ) {
        SetSystemBarColor(
            statusBarColor = MaterialTheme.gptColorScheme.topBar,
            statusBarDarkIcons = false,
            navigationBarColor = MaterialTheme.gptColorScheme.surface,
            navigationBarDarkIcons = !isSystemInDarkTheme()
        )

        Surface(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                topBar = { TopAppBar(meowViewModel = meowViewModel) },
                bottomBar = { BottomAppBar(meowViewModel = meowViewModel) },
                snackbarHost = {},
                floatingActionButton = {},
                floatingActionButtonPosition = FabPosition.End,
                containerColor = MaterialTheme.gptColorScheme.surface,
                contentColor = MaterialTheme.gptColorScheme.onSurface,
                content = {
                    Box(
                        modifier = Modifier.padding(it),
                        content = { Welcome(meowViewModel = meowViewModel) }
                    )
                }
            )
        }
    }
}