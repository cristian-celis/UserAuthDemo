package com.celisdev.userauthdemo.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.celisdev.userauthdemo.R

val MontserratFontFamily = FontFamily(
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_thin, FontWeight.Thin),
    Font(R.font.montserrat_black, FontWeight.Black),
    Font(R.font.montserrat_extrabold, FontWeight.ExtraBold),
    Font(R.font.montserrat_extralight, FontWeight.ExtraLight),
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = MontserratFontFamily,
        fontSize = 22.sp,
        fontWeight = FontWeight.W600,
        letterSpacing = (-0.5).sp,
        color = Color(0xFF09184D)
    ),
    titleMedium = TextStyle(
        fontFamily = MontserratFontFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.5).sp
    ),
    labelLarge = TextStyle(
        fontFamily = MontserratFontFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.5).sp,
        color = Color(0xFF2F2E2E)
    ),
    labelMedium = TextStyle(
        fontFamily = MontserratFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = (-0.5).sp,
    ),
    labelSmall = TextStyle(
        fontFamily = MontserratFontFamily,
        fontSize = 14.sp,
        letterSpacing = (-0.5).sp
    )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
