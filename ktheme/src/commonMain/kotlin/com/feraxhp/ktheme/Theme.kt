package com.feraxhp.ktheme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.materialkolor.DynamicMaterialTheme
import com.materialkolor.rememberDynamicMaterialThemeState

val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }
val LocalThemeSettings = compositionLocalOf<DynamicThemeSettings?> { null }

@Composable
fun DynamicTheme( content: @Composable () -> Unit ) {

    val dts: DynamicThemeSettings = remember { DynamicThemeSettings() }

    val seedColor by dts.seedColor.collectAsState()
    val theme by dts.theme.collectAsState()
    val useDynamicColor by dts.useDynamicColor.collectAsState()
    val useAmoled by dts.useAmoled.collectAsState()
    val style by dts.style.collectAsState()
    val contrastLevel by dts.contrastLevel.collectAsState()
    val extendedFidelity by dts.extendedFidelity.collectAsState()
    val hasAnimation by dts.hasAnimation.collectAsState()

    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(theme ?: systemIsDark) }

    val androidScheme = if (useDynamicColor) { getColorScheme(isDarkState.value) } else null

    val dynamicThemeState = rememberDynamicMaterialThemeState(
        seedColor = seedColor,
        isDark = isDarkState.value,
        isAmoled = useAmoled,
        style = style.paletteStyle,
        contrastLevel = contrastLevel,
        extendedFidelity = extendedFidelity,
        modifyColorScheme = { scheme ->
            return@rememberDynamicMaterialThemeState androidScheme ?: scheme
        }
    )

    SystemAppearance(isDarkState.value)

    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState,
        LocalThemeSettings provides dts
    ) {
        DynamicMaterialTheme(
            state = dynamicThemeState,
            animate = hasAnimation,
            content = { Surface { content() } }
        )
    }
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)

@Composable
internal expect fun getColorScheme(isDark: Boolean): ColorScheme?
