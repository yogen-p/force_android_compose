package com.yogenp.openweathercompose.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Defining Custom Theme Attributes

private val LightThemeColors = lightColors(
    primary = Blue600,
    primaryVariant = Blue400,
    onPrimary = Color.White,
    secondary = Blue300,
    secondaryVariant = Teal300,
    onSecondary = Color.White,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Grey1,
    onBackground = Color.White,
    surface = Color.White,
    onSurface = Black2,
)

private val DarkThemeColors = darkColors(
    primary = Blue700,
    primaryVariant = Color.White,
    onPrimary = Color.White,
    secondary = Color.Black,
    onSecondary = Black3,
    error = RedErrorLight,
    background = Black3,
    onBackground = Color.White,
    surface = Black3,
    onSurface = Color.Black,
)

@Composable
fun AppTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors
    ) {
        content()
    }
}