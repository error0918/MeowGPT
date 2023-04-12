package com.taeyeon.meowgpt

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberMeowState(
    drawerStateInitialValue: DrawerValue = DrawerValue.Closed
) = MeowState(
    drawerState = rememberDrawerState(initialValue = drawerStateInitialValue)
)

@OptIn(ExperimentalMaterial3Api::class)
data class MeowState(
    val drawerState: DrawerState
)