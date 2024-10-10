package com.feraxhp.ktheme

import androidx.compose.ui.graphics.Color
import com.feraxhp.ktheme.settings.ThemeSettings
import com.feraxhp.ktheme.settings.Tsettings
import com.materialkolor.Contrast
import com.materialkolor.PaletteStyle
import com.russhwolf.settings.Settings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class DynamicThemeSettings(
    private val scope: CoroutineScope,
    baseColor: Int ? = null
) {

    private val _settings: Tsettings = Tsettings()
    private val settings: Settings = Settings()

    val seedColor = _settings.seedColor.asStateFlow()
    val secondary = _settings.secondary.asStateFlow()
    val tertiary = _settings.tertiary.asStateFlow()
    val error = _settings.error.asStateFlow()
    val theme = _settings.theme.asStateFlow()
    val useDynamicColor = _settings.useDynamicColor.asStateFlow()
    val useAmoled = _settings.useAmoled.asStateFlow()
    val style = _settings.style.asStateFlow()
    val contrastLevel = _settings.contrastLevel.asStateFlow()
    val extendedFidelity = _settings.extendedFidelity.asStateFlow()
    val hasAnimation = _settings.hasAnimation.asStateFlow()

    init {
        this._settings.seedColor.value = Color(this.settings.getInt(ThemeSettings.seedColor.key, baseColor ?: 0X4C662B))
        this._settings.secondary.value = this.settings.getIntOrNull(ThemeSettings.secondary.key)?.let { Color(it) }
        this._settings.tertiary.value = this.settings.getIntOrNull(ThemeSettings.tertiary.key)?.let { Color(it) }
        this._settings.error.value = this.settings.getIntOrNull(ThemeSettings.error.key)?.let { Color(it) }
        this._settings.theme.value = this.settings.getBooleanOrNull(ThemeSettings.theme.key)
        this._settings.useDynamicColor.value = this.settings.getBoolean(ThemeSettings.useDynamicColor.key, true)
        this._settings.useAmoled.value = this.settings.getBoolean(ThemeSettings.useAmoled.key, false)
        this._settings.style.value = this.getStyle(this.settings.getString(ThemeSettings.style.key, PaletteStyle.TonalSpot.name))
        this._settings.contrastLevel.value = this.settings.getDouble(ThemeSettings.contrastLevel.key, Contrast.Default.value)
        this._settings.extendedFidelity.value = this.settings.getBoolean(ThemeSettings.extendedFidelity.key, false)
        this._settings.hasAnimation.value = this.settings.getBoolean(ThemeSettings.hasAnimation.key, true)
    }

    fun setSeedColor(value: Color, invokeOnCompletion: () -> Unit = {}){
        this._settings.seedColor.value = value
        this.scope.launch {
            settings.putInt(
                value = value.value.toInt(),
                key = ThemeSettings.seedColor.key
            )
        }.invokeOnCompletion { invokeOnCompletion() }
    }
    private fun setColor(value: Color?, type: ThemeSettings ,invokeOnCompletion: () -> Unit = {}){
        this.scope.launch {
            if (value == null) {
                settings.remove(type.key)
            } else {
                settings.putInt(
                    value = value.value.toInt(),
                    key = type.key
                )
            }
        }.invokeOnCompletion { invokeOnCompletion() }
    }
    fun setSecondaryColor(value: Color?, invokeOnCompletion: () -> Unit = {}){
        this._settings.secondary.value = value
        this.setColor(value, ThemeSettings.secondary, invokeOnCompletion)
    }
    fun setTertiaryColor(value: Color?, invokeOnCompletion: () -> Unit = {}){
        this._settings.tertiary.value = value
        this.setColor(value, ThemeSettings.tertiary, invokeOnCompletion)
    }
    fun setErrorColor(value: Color?, invokeOnCompletion: () -> Unit = {}){
        this._settings.error.value = value
        this.setColor(value, ThemeSettings.error, invokeOnCompletion)
    }
    fun setTheme(value: Boolean?, invokeOnCompletion: () -> Unit = {}){
        this._settings.theme.value = value
        this.scope.launch {
            if (value == null) {
                settings.remove(ThemeSettings.theme.key)
            } else {
                settings.putBoolean(
                    value = value,
                    key = ThemeSettings.theme.key
                )
            }
        }.invokeOnCompletion { invokeOnCompletion() }
    }
    fun setUseDynamicColor(value: Boolean, invokeOnCompletion: () -> Unit = {}){
        this._settings.useDynamicColor.value = value
        this.scope.launch {
            settings.putBoolean(
                value = value,
                key = ThemeSettings.useDynamicColor.key
            )
        }.invokeOnCompletion { invokeOnCompletion() }
    }
    fun setUseAmoled(value: Boolean, invokeOnCompletion: () -> Unit = {}){
        this._settings.useAmoled.value = value
        this.scope.launch {
            settings.putBoolean(
                value = value,
                key = ThemeSettings.useAmoled.key
            )
        }.invokeOnCompletion { invokeOnCompletion() }
    }
    fun setStyle(value: PaletteStyles, invokeOnCompletion: () -> Unit = {}){
        this._settings.style.value = value
        this.scope.launch {
            settings.putString(
                ThemeSettings.style.key,
                value.name
            )
        }.invokeOnCompletion { invokeOnCompletion() }
    }
    fun setContrastLevel(value: Double, invokeOnCompletion: () -> Unit = {}){
        this._settings.contrastLevel.value = value
        this.scope.launch {
            settings.putDouble(
                value = value,
                key = ThemeSettings.contrastLevel.key
            )
        }.invokeOnCompletion { invokeOnCompletion() }
    }
    fun setExtendedFidelity(value: Boolean, invokeOnCompletion: () -> Unit = {}){
        this._settings.extendedFidelity.value = value
        this.scope.launch {
            settings.putBoolean(
                value = value,
                key = ThemeSettings.extendedFidelity.key
            )
        }.invokeOnCompletion { invokeOnCompletion() }
    }
    fun setHasAnimation(value: Boolean, invokeOnCompletion: () -> Unit = {}){
        this._settings.hasAnimation.value = value
        this.scope.launch {
            settings.putBoolean(
                value = value,
                key = ThemeSettings.hasAnimation.key
            )
        }.invokeOnCompletion { invokeOnCompletion() }
    }
    private fun getStyle(value: String): PaletteStyles{
        return PaletteStyles.valueOf(value)
    }
}