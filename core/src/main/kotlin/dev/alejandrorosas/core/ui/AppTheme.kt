package dev.alejandrorosas.core.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette =
    darkColorScheme(
        primary = purple200,
        secondary = purple700,
        tertiary = teal200,
    )

private val LightColorPalette =
    lightColorScheme(
        primary = purple500,
        secondary = purple700,
        tertiary = teal200,
    )

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors =
        if (darkTheme) {
            DarkColorPalette
        } else {
            LightColorPalette
        }

    MaterialTheme(
        colorScheme = colors,
        content = content,
    )
}
