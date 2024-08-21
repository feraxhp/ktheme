package com.feraxhp.ktheme.components.theme

import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.feraxhp.ktheme.LocalThemeSettings
import com.feraxhp.ktheme.components.Density
import com.feraxhp.ktheme.components.Segment
import com.feraxhp.ktheme.components.SegmentedButton
import com.feraxhp.ktheme.icons.ThemeIcons
import com.feraxhp.ktheme.icons.theme.Cpu
import com.feraxhp.ktheme.icons.theme.Moon
import com.feraxhp.ktheme.icons.theme.Sun

@Composable
fun ThemeSelector(
    modifier: Modifier = Modifier,
    density: Density = Density.Default,
    noLabels: Boolean = false
) {

    val dts = LocalThemeSettings.current
    val theme = dts!!.theme.collectAsState()

    SegmentedButton(
        modifier = Modifier
            .widthIn(Dp.Unspecified, 400.dp)
            .then(modifier)
        ,
        segments = listOf(
            Segment(text = if (noLabels) "" else "System", icon = ThemeIcons.Cpu, onClick = { dts.setTheme(null) }),
            Segment(text = if (noLabels) "" else "Dark", icon = ThemeIcons.Moon, onClick = { dts.setTheme(true) }),
            Segment(text = if (noLabels) "" else "Light", icon = ThemeIcons.Sun, onClick = { dts.setTheme(false) })
        ),
        selectedValue = when (theme.value) { null -> 0 true -> 1 false -> 2 },
        density = density,
        showCheck = false
    )
}