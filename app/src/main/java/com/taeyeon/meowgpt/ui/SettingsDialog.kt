package com.taeyeon.meowgpt.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taeyeon.meowgpt.MeowViewModel
import com.taeyeon.meowgpt.theme.gptColorScheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsDialog(meowViewModel: MeowViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.gptColorScheme.textPrompt.copy(alpha = 0.1f))
            .padding(12.dp)
            .pointerInput(Unit) {
                detectTapGestures {
                    meowViewModel.settingsDialog = false
                }
            }
    ) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color.Black,
            contentColor = Color.White,
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .align(Alignment.BottomCenter)
                .pointerInput(Unit) {
                    detectTapGestures { }
                }
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 12.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f)
                ) {
                    Text(
                        text = "Settings",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Surface(
                        onClick = { meowViewModel.settingsDialog = false },
                        shape = RoundedCornerShape(20),
                        color = Color.Transparent,
                        contentColor = LocalContentColor.current,
                        modifier = Modifier.size(48.dp)
                    ) {
                        Image(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(LocalContentColor.current),
                            modifier = Modifier
                                .padding(12.dp)
                                .size(24.dp)
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f)
                ) {
                    Text(
                        text = "Dark Mode",
                        color = Color.LightGray,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Switch(
                        checked = meowViewModel.darkMode,
                        onCheckedChange = { meowViewModel.darkMode = it }
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Text(
                        text = "Export data",
                        color = Color.LightGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.clickable {  }
                    )
                    Spacer(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .width(2.dp)
                            .fillMaxHeight()
                            .background(
                                color = Color.LightGray,
                                shape = CircleShape
                            )
                    )
                    Text(
                        text = "Delete account",
                        color = Color.LightGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.clickable {  }
                    )
                }
            }
        }
    }
}