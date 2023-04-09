package com.taeyeon.meowgpt.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import com.taeyeon.meowgpt.R

@OptIn(ExperimentalTextApi::class)
fun nanumSquareNeo(fontWeight: FontWeight) = Font(
    R.font.nanumsquareneo,
    weight = fontWeight,
    variationSettings = FontVariation.Settings(
        FontVariation.weight(fontWeight.weight)
    )
)

val nanumSquareNeo = FontFamily(
    nanumSquareNeo(FontWeight.Thin),
    nanumSquareNeo(FontWeight.ExtraLight),
    nanumSquareNeo(FontWeight.Light),
    nanumSquareNeo(FontWeight.Normal),
    nanumSquareNeo(FontWeight.Medium),
    nanumSquareNeo(FontWeight.SemiBold),
    nanumSquareNeo(FontWeight.Bold),
    nanumSquareNeo(FontWeight.ExtraBold),
    nanumSquareNeo(FontWeight.Black),
    nanumSquareNeo(FontWeight.W100),
    nanumSquareNeo(FontWeight.W200),
    nanumSquareNeo(FontWeight.W300),
    nanumSquareNeo(FontWeight.W400),
    nanumSquareNeo(FontWeight.W500),
    nanumSquareNeo(FontWeight.W600),
    nanumSquareNeo(FontWeight.W700),
    nanumSquareNeo(FontWeight.W800),
    nanumSquareNeo(FontWeight.W900)
)

val Typography = Typography(
    displayLarge = Typography().displayLarge.copy(fontFamily = nanumSquareNeo),
    displayMedium = Typography().displayMedium.copy(fontFamily = nanumSquareNeo),
    displaySmall = Typography().displaySmall.copy(fontFamily = nanumSquareNeo),
    headlineLarge = Typography().headlineLarge.copy(fontFamily = nanumSquareNeo),
    headlineMedium = Typography().headlineMedium.copy(fontFamily = nanumSquareNeo),
    headlineSmall = Typography().headlineSmall.copy(fontFamily = nanumSquareNeo),
    titleLarge = Typography().titleLarge.copy(fontFamily = nanumSquareNeo),
    titleMedium = Typography().titleMedium.copy(fontFamily = nanumSquareNeo),
    titleSmall = Typography().titleSmall.copy(fontFamily = nanumSquareNeo),
    bodyLarge = Typography().bodyLarge.copy(fontFamily = nanumSquareNeo),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = nanumSquareNeo),
    bodySmall = Typography().bodySmall.copy(fontFamily = nanumSquareNeo),
    labelLarge = Typography().labelLarge.copy(fontFamily = nanumSquareNeo),
    labelMedium = Typography().labelMedium.copy(fontFamily = nanumSquareNeo),
    labelSmall = Typography().labelSmall.copy(fontFamily = nanumSquareNeo)
)