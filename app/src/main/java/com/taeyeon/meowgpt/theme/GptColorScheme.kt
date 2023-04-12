package com.taeyeon.meowgpt.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color


val MaterialTheme.gptColorScheme: GptColorScheme
    @Composable get() {
        return if (this.colorScheme.surface == light_surface)
            GptColorScheme(
                topBar = topBar,
                sideBar = sideBar,
                sideBarVariant = sideBarVariant,
                gptBackground = gptBackground,
                tint = tint,
                onTopBar = onTopBar,
                onSideBar = onSideBar,
                onGptBackground = onGptBackground,
                onTint = onTint,
                borderOnSideBar = borderOnSideBar,

                surface = dark_surface,
                surfaceVariant = dark_surfaceVariant,
                surfacePrompt = dark_surfacePrompt,
                myChat = dark_myChat,
                gptChat = dark_gptChat,
                fab = dark_fab,
                onSurface = dark_onSurface,
                onSurfaceVariant = dark_onSurfaceVariant,
                textMyChat = dark_textMyChat,
                textGptChat = dark_textGptChat,
                textHint = dark_textHint,
                textPrompt = dark_textPrompt,
                textSub = dark_textSub,
                textRegenerate = dark_textRegenerate,
                iconEnabled = dark_iconEnabled,
                iconDisabled = dark_iconDisabled,
                iconSub = dark_iconSub,
                iconFocused = dark_iconFocused,
                borderBlock = dark_borderBlock,
                borderTopBar = dark_borderTopBar,
                borderDiv = dark_borderDiv,
                borderFab = dark_borderFab,
            )
        else
            GptColorScheme(
                topBar = topBar,
                sideBar = sideBar,
                sideBarVariant = sideBarVariant,
                gptBackground = gptBackground,
                tint = tint,
                onTopBar = onTopBar,
                onSideBar = onSideBar,
                onGptBackground = onGptBackground,
                onTint = onTint,
                borderOnSideBar = borderOnSideBar,

                surface = light_surface,
                surfaceVariant = light_surfaceVariant,
                surfacePrompt = light_surfacePrompt,
                myChat = light_myChat,
                gptChat = light_gptChat,
                fab = light_fab,
                onSurface = light_onSurface,
                onSurfaceVariant = light_onSurfaceVariant,
                textMyChat = light_textMyChat,
                textGptChat = light_textGptChat,
                textHint = light_textHint,
                textPrompt = light_textPrompt,
                textSub = light_textSub,
                textRegenerate = light_textRegenerate,
                iconEnabled = light_iconEnabled,
                iconDisabled = light_iconDisabled,
                iconSub = light_iconSub,
                iconFocused = light_iconFocused,
                borderBlock = light_borderBlock,
                borderTopBar = light_borderTopBar,
                borderDiv = light_borderDiv,
                borderFab = light_borderFab,
            )
    }

@Stable
class GptColorScheme(
    topBar: Color,
    sideBar: Color,
    sideBarVariant: Color,
    gptBackground: Color,
    tint: Color,
    onTopBar: Color,
    onSideBar: Color,
    onGptBackground: Color,
    onTint: Color,
    borderOnSideBar: Color,

    surface: Color,
    surfaceVariant: Color,
    surfacePrompt: Color,
    myChat: Color,
    gptChat: Color,
    fab: Color,
    onSurface: Color,
    onSurfaceVariant: Color,
    textMyChat: Color,
    textGptChat: Color,
    textHint: Color,
    textPrompt: Color,
    textSub: Color,
    textRegenerate: Color,
    iconEnabled: Color,
    iconDisabled: Color,
    iconSub: Color,
    iconFocused: Color,
    borderBlock: Color,
    borderTopBar: Color,
    borderDiv: Color,
    borderFab: Color
) {
    var topBar by mutableStateOf(topBar, structuralEqualityPolicy())
        internal set
    var sideBar by mutableStateOf(sideBar, structuralEqualityPolicy())
        internal set
    var sideBarVariant by mutableStateOf(sideBarVariant, structuralEqualityPolicy())
        internal set
    var gptBackground by mutableStateOf(gptBackground, structuralEqualityPolicy())
        internal set
    var tint by mutableStateOf(tint, structuralEqualityPolicy())
        internal set
    var onTopBar by mutableStateOf(onTopBar, structuralEqualityPolicy())
        internal set
    var onSideBar by mutableStateOf(onSideBar, structuralEqualityPolicy())
        internal set
    var onGptBackground by mutableStateOf(onGptBackground, structuralEqualityPolicy())
        internal set
    var onTint by mutableStateOf(onTint, structuralEqualityPolicy())
        internal set
    var borderOnSideBar by mutableStateOf(borderOnSideBar, structuralEqualityPolicy())
        internal set

    var surface by mutableStateOf(surface, structuralEqualityPolicy())
        internal set
    var surfaceVariant by mutableStateOf(surfaceVariant, structuralEqualityPolicy())
        internal set
    var surfacePrompt by mutableStateOf(surfacePrompt, structuralEqualityPolicy())
        internal set
    var myChat by mutableStateOf(myChat, structuralEqualityPolicy())
        internal set
    var gptChat by mutableStateOf(gptChat, structuralEqualityPolicy())
        internal set
    var fab by mutableStateOf(fab, structuralEqualityPolicy())
        internal set
    var onSurface by mutableStateOf(onSurface, structuralEqualityPolicy())
        internal set
    var onSurfaceVariant by mutableStateOf(onSurfaceVariant, structuralEqualityPolicy())
        internal set
    var textMyChat by mutableStateOf(textMyChat, structuralEqualityPolicy())
        internal set
    var textGptChat by mutableStateOf(textGptChat, structuralEqualityPolicy())
        internal set
    var textHint by mutableStateOf(textHint, structuralEqualityPolicy())
        internal set
    var textPrompt by mutableStateOf(textPrompt, structuralEqualityPolicy())
        internal set
    var textSub by mutableStateOf(textSub, structuralEqualityPolicy())
        internal set
    var textRegenerate by mutableStateOf(textRegenerate, structuralEqualityPolicy())
        internal set
    var iconEnabled by mutableStateOf(iconEnabled, structuralEqualityPolicy())
        internal set
    var iconDisabled by mutableStateOf(iconDisabled, structuralEqualityPolicy())
        internal set
    var iconSub by mutableStateOf(iconSub, structuralEqualityPolicy())
        internal set
    var iconFocused by mutableStateOf(iconFocused, structuralEqualityPolicy())
        internal set
    var borderBlock by mutableStateOf(borderBlock, structuralEqualityPolicy())
        internal set
    var borderTopBar by mutableStateOf(borderTopBar, structuralEqualityPolicy())
        internal set
    var borderDiv by mutableStateOf(borderDiv, structuralEqualityPolicy())
        internal set
    var borderFab by mutableStateOf(borderFab, structuralEqualityPolicy())
        internal set

    /** Returns a copy of this ColorScheme, optionally overriding some of the values. */
    fun copy(
        topBar: Color = this.topBar,
        sideBar: Color = this.sideBar,
        sideBarVariant: Color = this.sideBarVariant,
        gptBackground: Color = this.gptBackground,
        tint: Color = this.tint,
        onTopBar: Color = this.onTopBar,
        onSideBar: Color = this.onSideBar,
        onGptBackground: Color = this.onGptBackground,
        onTint: Color = this.onTint,
        borderOnSideBar: Color = this.borderOnSideBar,

        surface: Color = this.surface,
        surfaceVariant: Color = this.surfaceVariant,
        surfacePrompt: Color = this.surfacePrompt,
        myChat: Color = this.myChat,
        gptChat: Color = this.gptChat,
        fab: Color = this.fab,
        onSurface: Color = this.onSurface,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        textMyChat: Color = this.textMyChat,
        textGptChat: Color = this.textGptChat,
        textHint: Color = this.textHint,
        textPrompt: Color = this.textPrompt,
        textSub: Color = this.textSub,
        textRegenerate: Color = this.textRegenerate,
        iconEnabled: Color = this.iconEnabled,
        iconDisabled: Color = this.iconDisabled,
        iconSub: Color = this.iconSub,
        iconFocused: Color = this.iconFocused,
        borderBlock: Color = this.borderBlock,
        borderTopBar: Color = this.borderTopBar,
        borderDiv: Color = this.borderDiv,
        borderFab: Color = this.borderFab
    ): GptColorScheme =
        GptColorScheme(
            topBar = topBar,
            sideBar = sideBar,
            sideBarVariant = sideBarVariant,
            gptBackground = gptBackground,
            tint = tint,
            onTopBar = onTopBar,
            onSideBar = onSideBar,
            onGptBackground = onGptBackground,
            onTint = onTint,
            borderOnSideBar = borderOnSideBar,

            surface = surface,
            surfaceVariant = surfaceVariant,
            surfacePrompt = surfacePrompt,
            myChat = myChat,
            gptChat = gptChat,
            fab = fab,
            onSurface = onSurface,
            onSurfaceVariant = onSurfaceVariant,
            textMyChat = textMyChat,
            textGptChat = textGptChat,
            textHint = textHint,
            textPrompt = textPrompt,
            textSub = textSub,
            textRegenerate = textRegenerate,
            iconEnabled = iconEnabled,
            iconDisabled = iconDisabled,
            iconSub = iconSub,
            iconFocused = iconFocused,
            borderBlock = borderBlock,
            borderTopBar = borderTopBar,
            borderDiv = borderDiv,
            borderFab = borderFab
        )

    override fun toString(): String = "GptColorScheme(" +
            "topBar=$topBar, " +
            "sideBar=$sideBar, " +
            "sideBarVariant=$sideBarVariant, " +
            "gptBackground=$gptBackground, " +
            "tint=$tint, " +
            "onTopBar=$onTopBar, " +
            "onSideBar=$onSideBar, " +
            "onGptBackground=$onGptBackground, " +
            "onTint=$onTint, " +
            "borderOnSideBar=$borderOnSideBar, " +

            "surface=$surface, " +
            "surfaceVariant=$surfaceVariant, " +
            "surfacePrompt=$surfacePrompt, " +
            "myChat=$myChat, " +
            "gptChat=$gptChat, " +
            "fab=$fab, " +
            "onSurface=$onSurface, " +
            "onSurfaceVariant=$onSurfaceVariant, " +
            "textMyChat=$textMyChat, " +
            "textGptChat=$textGptChat, " +
            "textHint=$textHint, " +
            "textPrompt=$textPrompt, " +
            "textSub=$textSub, " +
            "textRegenerate=$textRegenerate, " +
            "iconEnabled=$iconEnabled, " +
            "iconDisabled=$iconDisabled, " +
            "iconSub=$iconSub, " +
            "iconFocused=$iconFocused, " +
            "borderBlock=$borderBlock, " +
            "borderTopBar=$borderTopBar, " +
            "borderDiv=$borderDiv, " +
            "borderFab=$borderFab" +
            ")"
}
