package com.taeyeon.meowgpt.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.taeyeon.meowgpt.MeowViewModel
import com.taeyeon.meowgpt.theme.gptColorScheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SideBar(meowViewModel: MeowViewModel) {
    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            color = MaterialTheme.gptColorScheme.sideBar,
            contentColor = MaterialTheme.gptColorScheme.onSideBar,
            modifier = Modifier
                .width(288.dp)
                .fillMaxHeight()
        ) {
            Column {
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if (meowViewModel.state.drawerState.isOpen)
                        Modifier.pointerInput(Unit) {
                            detectTapGestures {
                                scope.launch {
                                    meowViewModel.state.drawerState.close()
                                }
                            }
                        }
                    else Modifier
                )
        ) {
            Surface(
                onClick = {
                    scope.launch {
                        meowViewModel.state.drawerState.close()
                    }
                },
                shape = RoundedCornerShape(12.dp),
                color = Color.Transparent,
                contentColor = LocalContentColor.current,
                modifier = Modifier
                    .padding(12.dp)
                    .size(48.dp)
                    .align(Alignment.TopStart)
            ) {
                Image(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.gptColorScheme.textPrompt),
                    modifier = Modifier
                        .padding(12.dp)
                        .size(24.dp)
                )
            }
        }
    }
}