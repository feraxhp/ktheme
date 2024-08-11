package com.feraxhp.dtheme

import androidx.compose.ui.graphics.Color
import com.feraxhp.dtheme.settings.ThemeSettings
import com.feraxhp.dtheme.settings.Tsettings
import com.materialkolor.Contrast
import com.materialkolor.PaletteStyle
import com.russhwolf.settings.Settings
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.asStateFlow


class DynamicThemeSettings {

    private val _settings: Tsettings = Tsettings()
    private val settings: Settings = Settings()

    val seedColor = _settings.seedColor.asStateFlow()
    val theme = _settings.theme.asStateFlow()
    val useDynamicColor = _settings.useDynamicColor.asStateFlow()
    val useAmoled = _settings.useAmoled.asStateFlow()
    val style = _settings.style.asStateFlow()
    val contrastLevel = _settings.contrastLevel.asStateFlow()
    val extendedFidelity = _settings.extendedFidelity.asStateFlow()
    val hasAnimation = _settings.hasAnimation.asStateFlow()

    init {
        this._settings.seedColor.value = Color(this.settings.getInt(ThemeSettings.seedColor.key, 0X4C662B))
        this._settings.theme.value = this.settings.getBooleanOrNull(ThemeSettings.theme.key)
        this._settings.useDynamicColor.value = this.settings.getBoolean(ThemeSettings.useDynamicColor.key, true)
        this._settings.useAmoled.value = this.settings.getBoolean(ThemeSettings.useAmoled.key, false)
        this._settings.style.value = this.getStyle(this.settings.getString(ThemeSettings.style.key, PaletteStyle.TonalSpot.name))
        this._settings.contrastLevel.value = this.settings.getDouble(ThemeSettings.contrastLevel.key, Contrast.Default.value)
        this._settings.extendedFidelity.value = this.settings.getBoolean(ThemeSettings.extendedFidelity.key, false)
        this._settings.hasAnimation.value = this.settings.getBoolean(ThemeSettings.hasAnimation.key, true)

    }

    fun setSeedColor(value: Color){
        this._settings.seedColor.value = value
        this.settings.putInt(
            value = value.value.toInt(),
            key = ThemeSettings.seedColor.key
        )
    }
    fun setTheme(value: Boolean?){
        this._settings.theme.value = value
        if(value == null ) { this.settings.remove(ThemeSettings.theme.key)}
        else {
            this.settings.putBoolean(
                value = value,
                key = ThemeSettings.theme.key
            )
        }
    }
    fun setUseDynamicColor(value: Boolean){
        this._settings.useDynamicColor.value = value
        this.settings.putBoolean(
            value = value,
            key = ThemeSettings.useDynamicColor.key
        )
    }
    fun setUseAmoled(value: Boolean){
        this._settings.useAmoled.value = value
        this.settings.putBoolean(
            value = value,
            key = ThemeSettings.useAmoled.key
        )
    }
    fun setStyle(value: PaletteStyles){
        this._settings.style.value = value
        this.settings.putString(
            ThemeSettings.style.key,
            value.name
        )
    }
    fun setContrastLevel(value: Double){
        this._settings.contrastLevel.value = value
        this.settings.putDouble(
            value = value,
            key = ThemeSettings.contrastLevel.key
        )
    }
    fun setExtendedFidelity(value: Boolean){
        this._settings.extendedFidelity.value = value
        this.settings.putBoolean(
            value = value,
            key = ThemeSettings.extendedFidelity.key
        )
    }
    fun setHasAnimation(value: Boolean){
        this._settings.hasAnimation.value = value
        this.settings.putBoolean(
            value = value,
            key = ThemeSettings.hasAnimation.key
        )
    }
    private fun getStyle(value: String): PaletteStyles{
        return PaletteStyles.valueOf(value)
    }
}