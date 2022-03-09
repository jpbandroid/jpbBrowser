package com.jpb.browser.oss.license.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.core.graphics.toColor
import com.jpb.browser.R

private val DarkColorPalette = darkColors(
    primary = colorAccentDark,
    primaryVariant = colorAccentDark,
    secondary = colorAccentDark
)

private val LightColorPalette = lightColors(
    primary = colorAccent,
    primaryVariant = colorAccent,
    secondary = colorAccent

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun Android_packages_apps_Jellylineage190Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}