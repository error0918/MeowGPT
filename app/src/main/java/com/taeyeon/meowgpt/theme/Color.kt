package com.taeyeon.meowgpt.theme

import androidx.compose.ui.graphics.Color


// Public

val topBar = Color(0xff343541) // TopBar
val sideBar = Color(0xff202123) // SideBar
val sideBarVariant = Color(0xff343541) // Selected Chat Room on SideBar
val gptBackground = Color(0xff10a37f) // GPT Background Color
val tint = Color(0xfffae69e) // Tint Color (like "NEW")

val onTopBar = Color(0xffd9d9e3) // TopBar Text and Icon
val onSideBar = Color(0xffececf1) // SideBar Text and Icon
val onGptBackground = Color(0xffffffff) // GPT Content Color
val onTint = Color(0xff343541) // on Tint Color (like "NEW")

val borderOnSideBar = Color(0xff4d4d4f) // Border On SideBar


// Light Theme

val light_surface = Color(0xffffffff) // Main Screen Surface
val light_surfaceVariant = Color(0xfff7f7f8) // Main Screen List
val light_surfacePrompt = Color(0xffffffff) // Prompt Background
val light_myChat = Color(0xffffffff) // My Chat Surface
val light_gptChat = Color(0xfff7f7f8) // GPT Chat Surface
val light_fab = Color(0xfff7f7f8) // Fab Surface

val light_onSurface = Color(0xff343541) // Main Screen Surface Text
val light_onSurfaceVariant = Color(0xff343541) // Main Screen List Text
val light_textMyChat = Color(0xff343541) // My Chat Text
val light_textGptChat = Color(0xff374151) // GPT Chat Text
val light_textHint = Color(0xff8e8ea0) // Hint Text
val light_textPrompt = Color(0xff000000) // Prompt Text
val light_textSub = Color(0xff7f7f7f) // Bottom Text
val light_textRegenerate = Color(0xff40414f) // Regenerate Button Text

val light_iconEnabled = Color(0xff8e8ea0) // Enabled Send Icon
val light_iconDisabled = Color(0xffd2d2d9) // Disabled Send Icon
val light_iconSub = Color(0xffababbd) // Good / Hate Icon and Edit Icon
val light_iconFocused = Color(0xff40414f) // Regenerate Icon, Good / Hate Icon and Edit Icon

val light_borderBlock = Color(0xffe5e5e5) // Border Prompt and Messages
val light_borderTopBar = Color.Transparent // Border TopBar (disabled)
val light_borderDiv = Color(0xffd8d8e2) // Border Between Prompt and Messages
val light_borderFab = Color(0xffd9d9e3) // Border Floating Button


// Dark Theme

val dark_surface = Color(0xff343541) // Main Screen Surface
val dark_surfaceVariant = Color(0xff3e3f4b) // Main Screen List
val dark_surfacePrompt = Color(0xff40414f) // Prompt Background
val dark_myChat = Color(0xff343541) // My Chat Surface
val dark_gptChat = Color(0xff444654) // GPT Chat Surface
val dark_fab = Color(0xff575965) // Fab Surface

val dark_onSurface = Color(0xffececf1) // Main Screen Surface Text
val dark_onSurfaceVariant = Color(0xffececf1) // Main Screen List Text
val dark_textMyChat = Color(0xffececf1) // My Chat Text
val dark_textGptChat = Color(0xffd1d5db) // GPT Chat Text
val dark_textHint = Color(0xff8e8ea0) // Hint Text
val dark_textPrompt = Color(0xffffffff) // Prompt Text
val dark_textSub = Color(0xff9a9aa0) // Bottom Text
val dark_textRegenerate = Color(0xffd9d9e3) // Regenerate Button Text

val dark_iconEnabled = Color(0xffacacbe) // Enabled Send Icon
val dark_iconDisabled = Color(0xff5f606f) /// Disabled Send Icon
val dark_iconSub = Color(0xffacacbe) // Good / Hate Icon and Edit Icon
val dark_iconFocused = Color(0xffd9d9e3) // Regenerate Icon, Good / Hate Icon and Edit Icon

val dark_borderBlock = Color(0xff2a2b32) // Border Prompt and Messages
val dark_borderTopBar = Color(0xff5d5d67) // Border TopBar
val dark_borderDiv = Color(0xff5c5c66) // Border Between Prompt and Messages
val dark_borderFab = Color(0xff686a75) // Border Floating Button


// Theme System

val theme_light_primary = gptBackground
val theme_light_onPrimary = onGptBackground
val theme_light_primaryContainer = gptBackground
val theme_light_onPrimaryContainer = onGptBackground
val theme_light_secondary = tint
val theme_light_onSecondary = onTint
val theme_light_secondaryContainer = tint
val theme_light_onSecondaryContainer = onTint
val theme_light_tertiary = Color.Transparent
val theme_light_onTertiary = Color.Transparent
val theme_light_tertiaryContainer = Color.Transparent
val theme_light_onTertiaryContainer = Color.Transparent
val theme_light_error = Color.Red
val theme_light_errorContainer = Color.Red
val theme_light_onError = Color.White
val theme_light_onErrorContainer = Color.White
val theme_light_background = light_surface
val theme_light_onBackground = light_onSurface
val theme_light_surface = light_surface
val theme_light_onSurface = light_onSurface
val theme_light_surfaceVariant = light_surfaceVariant
val theme_light_onSurfaceVariant = light_onSurfaceVariant
val theme_light_outline = light_borderDiv
val theme_light_inverseOnSurface = dark_onSurface
val theme_light_inverseSurface = dark_surface
val theme_light_inversePrimary = Color.Transparent
val theme_light_surfaceTint = tint
val theme_light_outlineVariant = light_borderBlock
val theme_light_scrim = Color.Black

val theme_dark_primary = gptBackground
val theme_dark_onPrimary = onGptBackground
val theme_dark_primaryContainer = gptBackground
val theme_dark_onPrimaryContainer = onGptBackground
val theme_dark_secondary = tint
val theme_dark_onSecondary = onTint
val theme_dark_secondaryContainer = tint
val theme_dark_onSecondaryContainer = onTint
val theme_dark_tertiary = Color.Transparent
val theme_dark_onTertiary = Color.Transparent
val theme_dark_tertiaryContainer = Color.Transparent
val theme_dark_onTertiaryContainer = Color.Transparent
val theme_dark_error = Color.Red
val theme_dark_errorContainer = Color.Red
val theme_dark_onError = Color.White
val theme_dark_onErrorContainer = Color.White
val theme_dark_background = dark_surface
val theme_dark_onBackground = dark_onSurface
val theme_dark_surface = dark_surface
val theme_dark_onSurface = dark_onSurface
val theme_dark_surfaceVariant = dark_surfaceVariant
val theme_dark_onSurfaceVariant = dark_onSurfaceVariant
val theme_dark_outline = dark_borderDiv
val theme_dark_inverseOnSurface = light_onSurface
val theme_dark_inverseSurface = light_surface
val theme_dark_inversePrimary = Color.Transparent
val theme_dark_surfaceTint = tint
val theme_dark_outlineVariant = dark_borderBlock
val theme_dark_scrim = Color.White
