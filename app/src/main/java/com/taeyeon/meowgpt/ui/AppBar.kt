package com.taeyeon.meowgpt.ui

import android.content.Intent
import android.graphics.BlurMaskFilter
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taeyeon.meowgpt.MeowViewModel
import com.taeyeon.meowgpt.theme.gptColorScheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(meowViewModel: MeowViewModel) {
    Surface(
        color = MaterialTheme.gptColorScheme.topBar,
        contentColor = MaterialTheme.gptColorScheme.onTopBar
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 5.dp)
        ) {
            Text(
                text = "New chat",
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 48.dp + 10.dp)
            )
            Surface(
                onClick = { meowViewModel.isSideBarOpened = !meowViewModel.isSideBarOpened },
                shape = RoundedCornerShape(12.dp),
                color = Color.Transparent,
                contentColor = LocalContentColor.current,
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.CenterStart)
            ) {
                Image(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(LocalContentColor.current),
                    modifier = Modifier
                        .padding(12.dp)
                        .size(24.dp)
                )
            }
            Surface(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(20),
                color = Color.Transparent,
                contentColor = LocalContentColor.current,
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.CenterEnd)
            ) {
                Image(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(LocalContentColor.current),
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
fun BottomAppBar(meowViewModel: MeowViewModel) {
    val context = LocalContext.current

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
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        color = MaterialTheme.gptColorScheme.borderBlock
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(
                            min = 56.dp,
                            max = 168.dp
                        )
                        .drawBehind {
                            drawIntoCanvas { canvas ->
                                // Shadow Effect
                                canvas.drawRect(
                                    left = 0f,
                                    top = 0f,
                                    right = size.width,
                                    bottom = size.height,
                                    paint = Paint().apply {
                                        asFrameworkPaint()
                                            .apply {
                                                maskFilter = BlurMaskFilter(12.dp.toPx(), BlurMaskFilter.Blur.NORMAL)
                                                color = Color.Black
                                                    .copy(alpha = 0.1f)
                                                    .toArgb()
                                            }
                                    },
                                )
                            }
                        }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(
                                min = 56.dp,
                                max = 168.dp
                            )
                    ) {
                        BasicTextField(
                            value = meowViewModel.prompt,
                            onValueChange = { meowViewModel.prompt = it },
                            textStyle = MaterialTheme.typography.labelMedium.copy(
                                fontSize = 14.sp,
                                lineHeight = 18.sp,
                                color = MaterialTheme.gptColorScheme.textPrompt
                            ),
                            cursorBrush = SolidColor(
                                value = MaterialTheme.gptColorScheme.textPrompt
                            ),
                            decorationBox = { innerTextField ->
                                Box {
                                    if (meowViewModel.prompt.isEmpty()) {
                                        Text(
                                            text = "Send a message...",
                                            style = MaterialTheme.typography.labelMedium.copy(
                                                fontSize = 14.sp,
                                                lineHeight = 18.sp,
                                                color = MaterialTheme.gptColorScheme.textHint
                                            ),
                                        )
                                    }
                                    innerTextField()
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically)
                                .padding(
                                    top = 12.dp,
                                    bottom = 12.dp,
                                    start = 12.dp,
                                    end = 0.dp
                                )
                        )
                        if (meowViewModel.prompt.isEmpty()) {
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = Color.Transparent,
                                contentColor = LocalContentColor.current,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .size(48.dp)
                                    .align(Alignment.Bottom)
                            ) {
                                Image(
                                    imageVector = Icons.Rounded.Send,
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.gptColorScheme.iconDisabled),
                                    modifier = Modifier
                                        .padding(12.dp)
                                        .size(24.dp)
                                )
                            }
                        } else {
                            Surface(
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(12.dp),
                                color = Color.Transparent,
                                contentColor = LocalContentColor.current,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .size(48.dp)
                                    .align(Alignment.Bottom)
                            ) {
                                Image(
                                    imageVector = Icons.Rounded.Send,
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.gptColorScheme.iconEnabled),
                                    modifier = Modifier
                                        .padding(12.dp)
                                        .size(24.dp)
                                )
                            }
                        }
                    }
                }
                Surface(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(12.dp),
                    color = Color.Transparent,
                    contentColor = LocalContentColor.current,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(48.dp)
                ) {
                    Image(
                        imageVector = Icons.Rounded.Refresh,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.gptColorScheme.iconFocused),
                        modifier = Modifier.size(24.dp)
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