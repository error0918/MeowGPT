@file:OptIn(ExperimentalMaterial3Api::class)

package com.taeyeon.meowgpt.ui

import android.content.Intent
import android.graphics.BlurMaskFilter
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taeyeon.meowgpt.theme.gptColorScheme


@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "New chat",
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.titleMedium
            )
        },
        navigationIcon = {
            Surface(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(20),
                color = Color.Transparent,
                contentColor = LocalContentColor.current
            ) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(6.dp)
                        .size(32.dp)
                )
            }
        },
        actions = {
            Surface(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(20),
                color = Color.Transparent,
                contentColor = LocalContentColor.current
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(6.dp)
                        .size(32.dp)
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.gptColorScheme.topBar,
            scrolledContainerColor = MaterialTheme.gptColorScheme.topBar,
            navigationIconContentColor = MaterialTheme.gptColorScheme.onTopBar,
            titleContentColor = MaterialTheme.gptColorScheme.onTopBar,
            actionIconContentColor = MaterialTheme.gptColorScheme.onTopBar
        )
    )
}

@Composable
fun BottomAppBar() {
    val context = LocalContext.current
    val hapticFeedback = LocalHapticFeedback.current

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.gptColorScheme.surfacePrompt,
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.gptColorScheme.borderDiv
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    color = MaterialTheme.gptColorScheme.surfacePrompt,
                    shape = RoundedCornerShape(20),
                    border = BorderStroke(
                        width = 2.dp,
                        color = MaterialTheme.gptColorScheme.borderBlock
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(
                            min = 46.dp,
                            max = 92.dp
                        )
                        .drawBehind {
                            drawIntoCanvas { canvas ->
                                val paint = Paint()
                                paint
                                    .asFrameworkPaint()
                                    .apply {
                                        maskFilter =
                                            BlurMaskFilter(12.dp.toPx(), BlurMaskFilter.Blur.NORMAL)
                                        color = Color.Black
                                            .copy(alpha = 0.1f)
                                            .toArgb()
                                    }

                                canvas.drawRect(
                                    left = 0f,
                                    top = 0f,
                                    right = size.width,
                                    bottom = size.height,
                                    paint = paint,
                                )
                            }
                        }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        var text by rememberSaveable { mutableStateOf("") }

                        BasicTextField(
                            value = text,
                            onValueChange = { text = it },
                            modifier = Modifier
                                .weight(1f)
                                .padding(
                                    top = 12.dp,
                                    bottom = 12.dp,
                                    start = 12.dp,
                                    end = 6.dp
                                ),
                            textStyle = MaterialTheme.typography.labelMedium.copy(
                                fontSize = 14.sp,
                                color = MaterialTheme.gptColorScheme.textPrompt
                            ),
                            cursorBrush = SolidColor(
                                value = MaterialTheme.gptColorScheme.textPrompt
                            ),
                            decorationBox = { innerTextField ->
                                Box {
                                    if (text.isEmpty()) {
                                        Text(
                                            text = "Send a message...",
                                            style = MaterialTheme.typography.labelMedium.copy(
                                                fontSize = 14.sp,
                                                color = MaterialTheme.gptColorScheme.textHint
                                            ),
                                        )
                                    }
                                    innerTextField()
                                }
                            }
                        )
                        Surface(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(20),
                            color = Color.Transparent,
                            contentColor = LocalContentColor.current
                        ) {
                            Image(
                                imageVector = Icons.Rounded.Send,
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(
                                    if (text.isNotEmpty()) MaterialTheme.gptColorScheme.iconEnabled
                                    else MaterialTheme.gptColorScheme.iconDisabled
                                ),
                                modifier = Modifier
                                    .padding(4.dp)
                                    .size(24.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.width(6.dp))
                Surface(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(20),
                    color = Color.Transparent,
                    contentColor = LocalContentColor.current
                ) {
                    Image(
                        imageVector = Icons.Rounded.Refresh,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.gptColorScheme.iconFocused),
                        modifier = Modifier
                            .padding(4.dp)
                            .size(24.dp)
                    )
                }
            }
            val subText = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(textDecoration = TextDecoration.Underline)
                ) {
                    pushStringAnnotation("Name", "https://github.com/error0918/MeowGPT")
                    append("MeowGPT Apr 9 Version")
                    pop()
                }
                append(". Free Research Preview. MeowGPT may produce inaccurate information about people, places, or facts")
            }
            ClickableText(
                text = subText,
                onClick = { offset ->
                    subText.getStringAnnotations(
                        tag = "Name",
                        start = offset,
                        end = offset
                    ).firstOrNull()?.let { annotation ->
                        hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                        context.startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(annotation.item)
                            )
                        )
                    }
                },
                style = MaterialTheme.typography.labelMedium.copy(
                    color = MaterialTheme.gptColorScheme.textSub,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    lineHeight = 14.sp
                ),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )
        }
    }
}