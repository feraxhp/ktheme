import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
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
    density: Density = Density.Default
) {

    val dts = LocalThemeSettings.current
    val theme = dts!!.theme.collectAsState()

    SegmentedButton(
        modifier = modifier,
        segments = listOf(
            Segment(text = "System", icon = ThemeIcons.Cpu, onClick = { dts.setTheme(null) }),
            Segment(text = "Dark", icon = ThemeIcons.Moon, onClick = { dts.setTheme(true) }),
            Segment(text = "Light", icon = ThemeIcons.Sun, onClick = { dts.setTheme(false) })
        ),
        selectedValue = when (theme.value) { null -> 0 true -> 1 false -> 2 },
        density = density,
        showCheck = false
    )
}