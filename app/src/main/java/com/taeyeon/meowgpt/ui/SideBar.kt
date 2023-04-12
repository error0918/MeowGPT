package com.taeyeon.meowgpt.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ChatBubbleOutline
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Logout
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.WebAsset
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 12.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                SideBarItem(
                    onClick = { /*TODO*/ },
                    imageVector = Icons.Rounded.Add,
                    text = "New chat",
                    border =  BorderStroke(
                        width = 2.dp,
                        color = MaterialTheme.gptColorScheme.borderOnSideBar
                    )
                )
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(space = 12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    items(listOf("요구요구", "아가아가", "1234", "요구요구", "아가아가", "1234", "요구요구", "아가아가", "1234")) {
                        SideBarItem(
                            onClick = { /*TODO*/ },
                            imageVector = Icons.Rounded.ChatBubbleOutline,
                            text = it
                        )
                    }
                }
                Divider(
                    thickness = 2.dp,
                    color = MaterialTheme.gptColorScheme.borderOnSideBar
                )
                SideBarItem(
                    onClick = { /*TODO*/ },
                    imageVector = Icons.Rounded.Delete,
                    text = "Clear conversations"
                )
                SideBarItem(
                    onClick = { /*TODO*/ },
                    imageVector = Icons.Rounded.Person,
                    text = "Upgrade to Plus",
                    indicator = {
                        Text(
                            text = "NEW",
                            color = MaterialTheme.gptColorScheme.onTint,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier
                                .background(
                                    color = MaterialTheme.gptColorScheme.tint,
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .padding(6.dp)
                        )
                    }
                )
                SideBarItem(
                    onClick = { meowViewModel.settingsDialog = true },
                    imageVector = Icons.Rounded.Settings,
                    text = "Settings"
                )
                SideBarItem(
                    onClick = { /*TODO*/ },
                    imageVector = Icons.Rounded.WebAsset,
                    text = "Get Help"
                )
                SideBarItem(
                    onClick = { /*TODO*/ },
                    imageVector = Icons.Rounded.Logout,
                    text = "Log out"
                )
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SideBarItem(
    onClick: () -> Unit,
    imageVector: ImageVector,
    text: String,
    indicator: @Composable () -> Unit = {  },
    border: BorderStroke? = null
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        color = Color.Transparent,
        contentColor = LocalContentColor.current,
        border = border,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = 6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Image(
                imageVector = imageVector,
                contentDescription = text,
                colorFilter = ColorFilter.tint(LocalContentColor.current),
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = text,
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.weight(1f)
            )
            indicator()
        }
    }
}