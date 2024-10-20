package com.feraxhp.ktheme.components.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.feraxhp.ktheme.LocalThemeSettings
import com.feraxhp.ktheme.components.colorPicker.ColorPicker

@Composable
fun SeedColorPicker(
    modifier: Modifier = Modifier
){
    val dts = LocalThemeSettings.current
    val dynamic by dts!!.useDynamicColor.collectAsState()

    ColorPicker(
        modifier = modifier,
        initialColor = MaterialTheme.colorScheme.primary,
        onColorChange = {
            if (dynamic) dts!!.setUseDynamicColor(false)
            dts!!.setSeedColor(it)
        }
    )
}