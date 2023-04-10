@file:OptIn(ExperimentalMaterial3Api::class)

package com.taeyeon.meowgpt.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material.icons.outlined.WarningAmber
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taeyeon.meowgpt.MeowViewModel
import com.taeyeon.meowgpt.theme.gptColorScheme


@Composable
fun Welcome(meowViewModel: MeowViewModel) {
    Surface(
        color = MaterialTheme.gptColorScheme.surface,
        contentColor = MaterialTheme.gptColorScheme.onSurface
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            Text(
                text = "MeowGPT",
                fontSize = 40.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.WbSunny,
                    contentDescription = null,
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    text = "Examples",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Surface(
                onClick = { /* TODO */ },
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.gptColorScheme.surfaceVariant,
                contentColor = MaterialTheme.gptColorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "\"Explain quantum computing in simple terms\" →",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
            Surface(
                onClick = { /* TODO */ },
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.gptColorScheme.surfaceVariant,
                contentColor = MaterialTheme.gptColorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "\"Got any creative ideas for a 10 year old’s birthday?\" →",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
            Surface(
                onClick = { /* TODO */ },
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.gptColorScheme.surfaceVariant,
                contentColor = MaterialTheme.gptColorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "\"How do I make an HTTP request in Javascript?\" →",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }

            Spacer(modifier = Modifier)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.StarOutline,
                    contentDescription = null,
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    text = "Capabilities",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.gptColorScheme.surfaceVariant,
                contentColor = MaterialTheme.gptColorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Remembers what user said earlier in the conversation",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.gptColorScheme.surfaceVariant,
                contentColor = MaterialTheme.gptColorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Allows user to provide follow-up corrections",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.gptColorScheme.surfaceVariant,
                contentColor = MaterialTheme.gptColorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Trained to decline inappropriate requests",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }

            Spacer(modifier = Modifier)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.WarningAmber,
                    contentDescription = null,
                    modifier = Modifier.size(35.dp)
                )
                Text(
                    text = "Limitations",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.gptColorScheme.surfaceVariant,
                contentColor = MaterialTheme.gptColorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "May occasionally generate incorrect information",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.gptColorScheme.surfaceVariant,
                contentColor = MaterialTheme.gptColorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "May occasionally produce harmful instructions or biased content",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.gptColorScheme.surfaceVariant,
                contentColor = MaterialTheme.gptColorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Limited knowledge of world and events after 2021",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}