package com.feraxhp.dtheme.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

@Composable
internal actual fun SystemAppearance(isDark: Boolean) {
}

@Composable
internal actual fun getColorScheme(
    isDark: Boolean,
    dynamicColor: Boolean
): ColorScheme? { return null }