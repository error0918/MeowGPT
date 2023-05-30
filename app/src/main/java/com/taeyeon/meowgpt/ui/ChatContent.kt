package com.taeyeon.meowgpt.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbDown
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.ContentPaste
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.ThumbDown
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material.icons.twotone.Android
import androidx.compose.material.icons.twotone.CatchingPokemon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.taeyeon.meowgpt.MeowViewModel
import com.taeyeon.meowgpt.theme.gptColorScheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatContent(meowViewModel: MeowViewModel) {
    val me = "ME"
    val meowGPT = "MEOW_GPT"
    val thumbNone = "NONE"
    val thumbHate = "HATE"
    val thumbGood = "GOOD"

    val chat: @Composable ColumnScope.(message: String,  sender: String) -> Unit = { message: String, sender: String ->
        val clipboardManager = LocalClipboardManager.current

        var editing by remember { mutableStateOf(false) }
        var copied by remember { mutableStateOf(false) }
        var thumb by remember { mutableStateOf(thumbNone) }

        LaunchedEffect(copied) {
            if (copied) {
                delay(2000)
                copied = false
            }
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = if (sender == me) MaterialTheme.gptColorScheme.myChat else  MaterialTheme.gptColorScheme.gptChat,
            contentColor = if (sender == me) MaterialTheme.gptColorScheme.textMyChat else MaterialTheme.gptColorScheme.textGptChat
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (sender == me) {
                        Surface(
                            shape = RoundedCornerShape(2.dp),
                            color = MaterialTheme.gptColorScheme.tint,
                            contentColor = MaterialTheme.gptColorScheme.onTint,
                            modifier = Modifier.size(32.dp),
                        ) {
                            Image(
                                imageVector = Icons.TwoTone.Android,
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(LocalContentColor.current),
                                modifier = Modifier
                                    .padding(6.dp)
                                    .size(20.dp)
                            )
                            // Icon Content
                        }
                    } else {
                        Surface(
                            shape = RoundedCornerShape(2.dp),
                            color = MaterialTheme.gptColorScheme.gptBackground,
                            contentColor = MaterialTheme.gptColorScheme.onGptBackground,
                            modifier = Modifier.size(32.dp),
                        ) {
                            Image(
                                imageVector = Icons.TwoTone.CatchingPokemon,
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(LocalContentColor.current),
                                modifier = Modifier
                                    .padding(6.dp)
                                    .size(20.dp)
                            )
                            // Icon Content
                        }
                    }
                    SelectionContainer {
                        Text(
                            text = message,
                            modifier = Modifier.padding(vertical = 6.dp)
                        )
                    }
                }
                if (sender == meowGPT || !editing) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(
                            space = 8.dp,
                            alignment = Alignment.End
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        if (sender == me) {
                            Surface(
                                onClick = { editing = true },
                                shape = RoundedCornerShape(3.dp),
                                color = Color.Transparent,
                                contentColor = LocalContentColor.current,
                                modifier = Modifier.size(24.dp)
                            ) {
                                Image(
                                    imageVector = Icons.Rounded.Edit,
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.gptColorScheme.iconEnabled),
                                    modifier = Modifier
                                        .padding(3.dp)
                                        .size(18.dp)
                                )
                            }
                        } else {
                            Surface(
                                onClick = {
                                    clipboardManager.setText(AnnotatedString(message))
                                    copied = true
                                },
                                shape = RoundedCornerShape(3.dp),
                                color = Color.Transparent,
                                contentColor = LocalContentColor.current,
                                modifier = Modifier.size(24.dp)
                            ) {
                                Image(
                                    imageVector = if (copied) Icons.Rounded.Check else Icons.Rounded.ContentPaste,
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.gptColorScheme.iconEnabled),
                                    modifier = Modifier
                                        .padding(3.dp)
                                        .size(18.dp)
                                )
                            }
                            if (thumb != thumbGood) {
                                Surface(
                                    onClick = {
                                        thumb = if (thumb == thumbHate) thumbNone else thumbHate
                                    },
                                    shape = RoundedCornerShape(3.dp),
                                    color = Color.Transparent,
                                    contentColor = LocalContentColor.current,
                                    modifier = Modifier.size(24.dp)
                                ) {
                                    Image(
                                        imageVector = if (thumb == thumbHate) Icons.Rounded.ThumbDown else Icons.Outlined.ThumbDown,
                                        contentDescription = null,
                                        colorFilter = ColorFilter.tint(MaterialTheme.gptColorScheme.iconEnabled),
                                        modifier = Modifier
                                            .padding(3.dp)
                                            .size(18.dp)
                                    )
                                }
                            }
                            if (thumb != thumbHate) {
                                Surface(
                                    onClick = {
                                        thumb = if (thumb == thumbGood) thumbNone else thumbGood
                                    },
                                    shape = RoundedCornerShape(3.dp),
                                    color = Color.Transparent,
                                    contentColor = LocalContentColor.current,
                                    modifier = Modifier.size(24.dp)
                                ) {
                                    Image(
                                        imageVector = if (thumb == thumbGood) Icons.Rounded.ThumbUp else Icons.Outlined.ThumbUp,
                                        contentDescription = null,
                                        colorFilter = ColorFilter.tint(MaterialTheme.gptColorScheme.iconEnabled),
                                        modifier = Modifier
                                            .padding(3.dp)
                                            .size(18.dp)
                                    )
                                }
                            }
                        }
                    }
                } else {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(
                            space = 16.dp,
                            alignment = Alignment.CenterHorizontally
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(6.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.gptColorScheme.gptBackground,
                                contentColor = MaterialTheme.gptColorScheme.onGptBackground,
                                disabledContainerColor = MaterialTheme.gptColorScheme.gptBackground,
                                disabledContentColor = MaterialTheme.gptColorScheme.onGptBackground
                            ),
                            contentPadding = PaddingValues(horizontal = 12.dp)
                        ) {
                            Text(text = "Save & Submit")
                        }
                        OutlinedButton(
                            onClick = { editing = false },
                            shape = RoundedCornerShape(6.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = LocalContentColor.current,
                                disabledContentColor = LocalContentColor.current
                            ),
                            border = ButtonDefaults.outlinedButtonBorder.copy(brush = SolidColor(MaterialTheme.gptColorScheme.borderFab)),
                            contentPadding = PaddingValues(horizontal = 12.dp)
                        ) {
                            Text(text = "Cancel")
                        }
                    }
                }
            }
        }
        Divider(
            thickness = 2.dp,
            color = MaterialTheme.gptColorScheme.borderBlock
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        for (i in 0 .. 9) {
            chat(
                message = "고양이 계산기 만들어줘",
                sender = me
            )
            chat(
                message = """
                    이 코드는 콘솔에서 두 개의 숫자와 연산자를 입력받아 계산한 후 결과를 출력합니다. 사용자가 잘못된 연산자를 입력한 경우 예외를 발생시킵니다.
                    간단하게 코드를 설명하면, 먼저 num1, num2, operator, result 변수를 선언합니다. 사용자로부터 첫 번째 숫자와 두 번째 숫자, 그리고 연산자를 입력받습니다. operator 변수는 첫 번째 글자만 읽어와서 문자로 저장합니다.
                    그 후 when 식을 사용해서 연산자에 따라서 결과를 계산합니다. 마지막으로 형태로 결과를 출력합니다.
                """.trimIndent(),
                sender = meowGPT
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
    }
}