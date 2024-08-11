package com.feraxhp.dtheme.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.materialkolor.DynamicMaterialTheme
import com.materialkolor.DynamicMaterialThemeState
import com.materialkolor.rememberDynamicMaterialThemeState

val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }
internal val LocalThemeIsDynamic = compositionLocalOf { mutableStateOf(true) }

@Composable
fun DynamicTheme( content: @Composable () -> Unit ) {

    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(systemIsDark) }
    val isDynamic = remember { mutableStateOf(true) }
    val androidScheme = getColorScheme(isDarkState.value, isDynamic.value)

    val dynamicThemeState = rememberDynamicMaterialThemeState(
        seedColor = seed,
        isDark = isDarkState.value,
        modifyColorScheme = { scheme ->
            return@rememberDynamicMaterialThemeState androidScheme ?: scheme
        }
    )

    SystemAppearance(isDarkState.value)

    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState,
        LocalThemeIsDynamic provides isDynamic
    ) {
        DynamicMaterialTheme(
            state = dynamicThemeState,
            animate = true,
            content = { Surface { content() } }
        )
    }
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)

@Composable
internal expect fun getColorScheme(isDark: Boolean, dynamicColor: Boolean = true): ColorScheme?
