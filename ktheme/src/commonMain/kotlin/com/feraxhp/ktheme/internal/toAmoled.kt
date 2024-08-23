package com.feraxhp.ktheme.internal

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color


internal fun toAmoled(colorScheme: ColorScheme): ColorScheme {
    return ColorScheme(
        background = Color.Black,
        error = colorScheme.error,
        errorContainer = colorScheme.errorContainer,
        inverseOnSurface = colorScheme.inverseOnSurface,
        inversePrimary = colorScheme.inversePrimary,
        inverseSurface = colorScheme.inverseSurface,
        onBackground = Color.White,
        onError = colorScheme.onError,
        onErrorContainer = colorScheme.onErrorContainer,
        onPrimary = colorScheme.onPrimary,
        onPrimaryContainer = colorScheme.onPrimaryContainer,
        onSecondary = colorScheme.onSecondary,
        onSecondaryContainer = colorScheme.onSecondaryContainer,
        onSurface = Color.White,
        onSurfaceVariant = colorScheme.onSurfaceVariant,
        onTertiary = colorScheme.onTertiary,
        onTertiaryContainer = colorScheme.onTertiaryContainer,
        outline = colorScheme.outline,
        outlineVariant = colorScheme.outlineVariant,
        primary = colorScheme.primary,
        primaryContainer = colorScheme.primaryContainer,
        scrim = colorScheme.scrim,
        secondary = colorScheme.secondary,
        secondaryContainer = colorScheme.secondaryContainer,
        surface = Color.Black,
        surfaceTint = colorScheme.surfaceTint,
        surfaceBright = colorScheme.surfaceBright,
        surfaceDim = colorScheme.surfaceDim,
        surfaceContainer = colorScheme.surfaceContainer,
        surfaceContainerHigh = colorScheme.surfaceContainerHigh,
        surfaceContainerHighest = colorScheme.surfaceContainerHighest,
        surfaceContainerLow = colorScheme.surfaceContainerLow,
        surfaceContainerLowest = colorScheme.surfaceContainerLowest,
        surfaceVariant = colorScheme.surfaceVariant,
        tertiary = colorScheme.tertiary,
        tertiaryContainer = colorScheme.tertiaryContainer,
    )
}