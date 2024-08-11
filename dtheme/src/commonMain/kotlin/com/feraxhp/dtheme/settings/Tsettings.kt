package com.feraxhp.dtheme.settings

import androidx.compose.ui.graphics.Color
import com.feraxhp.dtheme.PaletteStyles
import com.materialkolor.Contrast
import com.materialkolor.PaletteStyle
import kotlinx.coroutines.flow.MutableStateFlow


internal data class Tsettings(
    val seedColor: MutableStateFlow<Color> =  MutableStateFlow(Color(0X4C662B)),
    val theme: MutableStateFlow<Boolean?> = MutableStateFlow(null),
    val useDynamicColor: MutableStateFlow<Boolean> = MutableStateFlow(true),
    val useAmoled: MutableStateFlow<Boolean> = MutableStateFlow(false),
    val style: MutableStateFlow<PaletteStyles> = MutableStateFlow(PaletteStyles.TonalSpot),
    val contrastLevel: MutableStateFlow<Double> = MutableStateFlow(Contrast.Default.value),
    val extendedFidelity: MutableStateFlow<Boolean> = MutableStateFlow(false),
    val hasAnimation: MutableStateFlow<Boolean> = MutableStateFlow(true)
)

internal enum class ThemeSettings(val key: String) {
    seedColor("TSSEEDCOLOR"),
    theme("TSTHEME"),
    useDynamicColor("TSUSEDYNAMICCOLOR"),
    useAmoled("TSUSEAMOLED"),
    style("TSSTYLE"),
    contrastLevel("TSCONTRASTLEVEL"),
    extendedFidelity("TSEXTENDEDFIDELITY"),
    hasAnimation("TSHASANIMATION"),
}

